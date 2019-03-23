package net.sheetbuilder.common.entity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.common.collect.Maps;

import java.util.Map;

public abstract class AbstractApiRequest implements RequestHandler<Map<String, String>, Map<String, Object>> {

    private Map<String, Object> result = Maps.newHashMap();

    @Override
    public final Map<String, Object> handleRequest(Map<String, String> data, Context context) {
        handle(data);

        return result;
    }

    protected final void putResult(String key, Object value) {
        this.result.put(key, value);
    }

    protected final void error(String message) {
        putResult("error", message);
    }

    protected abstract void handle(Map<String, String> data);
}
