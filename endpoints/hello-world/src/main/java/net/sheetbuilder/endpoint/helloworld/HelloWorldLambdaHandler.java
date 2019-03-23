package net.sheetbuilder.endpoint.helloworld;

import net.sheetbuilder.common.entity.AbstractApiRequest;

import java.util.Map;

public class HelloWorldLambdaHandler extends AbstractApiRequest {

    @Override
    protected void handle(Map<String, String> data) {
        putResult("hello", "world");
    }
}
