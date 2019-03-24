package net.sheetbuilder.endpoint;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import net.sheetbuilder.common.entity.AbstractApiRequest;
import net.sheetbuilder.common.entity.User;
import net.sheetbuilder.common.security.Hashing;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CreateAccountLambdaHandler extends AbstractApiRequest {

    private AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();

    @Override
    public void handle(Map<String, String> data) {
        User.Builder builder = User.newBuilder();

        if (!data.containsKey("password")) {
            error("password field is missing!");
            return;
        }

        if (!data.containsKey("email")) {
            error("email field is missing!");
            return;
        }

        DynamoDB dynamoDB = new DynamoDB(this.client);

        Table table = dynamoDB.getTable("sheetbuilderUsers");

        builder.withPasswordHash(Hashing.hash(data.get("password")));
        builder.withEmail(data.get("email"));
        builder.withFirstName(data.getOrDefault("firstName", ""));
        builder.withLastName(data.getOrDefault("lastName", ""));
        builder.withLastLogin(new Date());
        builder.withAccountCreated(new Date());
        builder.withUserId(UUID.randomUUID());

        User user = builder.build();

        try {
            PutItemOutcome outcome = table.putItem(new Item()
                    .withPrimaryKey("user_id", user.getUserId().toString())
                    .with("email", user.getEmail())
                    .with("password_hash", user.getPasswordHash())
                    .with("first_name", user.getFirstName())
                    .with("last_name", user.getLastName())
                    .with("account_created", user.getAccountCreated().getTime())
                    .with("last_login", user.getLastLogin().getTime()));

            putResult("success", "Successfully created user with id: " + user.getUserId());
            putResult("database_result", outcome.getPutItemResult().toString());
        } catch (Throwable throwable) {
            putResult("exception", new HashMap<String, String>() {{
                put("class", throwable.getClass().getName());
                put("message", throwable.getMessage());
            }});
            error("Unable to create new user!");
        }
    }
}
