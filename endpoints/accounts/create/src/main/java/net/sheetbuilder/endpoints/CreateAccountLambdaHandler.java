package net.sheetbuilder.endpoints;

import net.sheetbuilder.common.entity.AbstractApiRequest;
import net.sheetbuilder.common.entity.User;
import net.sheetbuilder.common.security.Hashing;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class CreateAccountLambdaHandler extends AbstractApiRequest {

    @Override
    public void handle(Map<String, String> data) {
        User.Builder builder = User.newBuilder();

        if (!data.containsKey("password")) {
            error("Password field is missing!");
            return;
        }

        if (!data.containsKey("email")) {
            error("Email field is missing!");
            return;
        }

        builder.withPasswordHash(Hashing.hash(data.get("password")));
        builder.withEmail(data.get("email"));
        builder.withFirstName(data.getOrDefault("firstName", ""));
        builder.withLastName(data.getOrDefault("lastName", ""));
        builder.withLastLogin(new Date());
        builder.withAccountCreated(new Date());
        builder.withUserId(UUID.randomUUID());

        User user = builder.build();

        putResult("userId", user.getUserId());
        putResult("email", user.getEmail());
        putResult("firstName", user.getFirstName());
        putResult("lastName", user.getLastName());
        putResult("fullName", user.getFullName());
        putResult("created", user.getAccountCreated());
        putResult("lastLogin", user.getLastLogin());
    }
}
