package net.sheetbuilder.endpoint.helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.Map;

public class HelloWorldLambdaHandler implements RequestHandler<Map<String, String>, Map<String, String>> {

    public Map<String, String> handleRequest(Map<String, String> data, Context context) {
        return new HashMap<String, String>() {{
            put("hello", "world");
        }};
    }
}
