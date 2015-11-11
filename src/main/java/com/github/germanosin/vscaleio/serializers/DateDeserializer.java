package com.github.germanosin.vscaleio.serializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by germanosin on 10.11.15.
 */
public class DateDeserializer implements JsonDeserializer<Date> {

    private static long epoch = 1262304000000L;

    ThreadLocal<SimpleDateFormat> sdt = new ThreadLocal<SimpleDateFormat>();

    public DateDeserializer() {

    }

    public SimpleDateFormat getDateFormat() {
        SimpleDateFormat result = sdt.get();
        if (result==null) {
            result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdt.set(result);
        }
        return result;
    }


    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            long time = jsonElement.getAsLong();
            if (time>0) {
                if (time < epoch) time = time * 1000;
                return new Date(time);
            }
        } catch (Exception ex) {
            try {
                return getDateFormat().parse(jsonElement.getAsString());
            } catch (ParseException e) {
                throw new JsonParseException("Invalid date form: "+jsonElement.getAsString(), e);
            }
        }
        return null;
    }
}
