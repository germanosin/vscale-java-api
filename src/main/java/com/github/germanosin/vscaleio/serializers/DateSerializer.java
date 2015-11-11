package com.github.germanosin.vscaleio.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by germanosin on 10.11.15.
 */
public class DateSerializer implements JsonSerializer<Date> {
    @Override
    public JsonElement serialize(Date src, Type type, JsonSerializationContext jsonSerializationContext) {
        return src == null ? null : new JsonPrimitive(src.getTime());
    }
}
