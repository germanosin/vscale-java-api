package com.github.germanosin.vscaleio.serializers;


import com.github.germanosin.vscaleio.dto.Consumption;
import com.github.germanosin.vscaleio.dto.ConsumptionItem;
import com.github.germanosin.vscaleio.dto.ConsumptionList;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by germanosin on 10.11.15.
 */
public class ConsumptionListDeserializer implements JsonDeserializer<ConsumptionList> {

    @Override
    public ConsumptionList deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Map<Long,Consumption> consumptions = new HashMap<Long, Consumption>();

        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            for(Map.Entry<String,JsonElement> element : jsonObject.entrySet()) {

                if (element.getValue().isJsonObject()) {
                   Long key = Long.parseLong(element.getKey());
                   consumptions.put(key, parseConsumption(element.getValue().getAsJsonObject(), jsonDeserializationContext));
                }

            }
        }

        return new ConsumptionList(consumptions);
    }

    private Consumption parseConsumption(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
        long total = 0;
        Map<String,ConsumptionItem> items = new HashMap<String, ConsumptionItem>();

        for(Map.Entry<String,JsonElement> element : jsonObject.entrySet()) {

            if (element.getKey().equals("summ")) {
                total = element.getValue().getAsLong();
            } else {
                ConsumptionItem consumptionItem = jsonDeserializationContext.deserialize(element.getValue(), ConsumptionItem.class);
                items.put(element.getKey(), consumptionItem);
            }
        }

        return new Consumption(items, total);
    }
}
