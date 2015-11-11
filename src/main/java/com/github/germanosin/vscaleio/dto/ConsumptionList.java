package com.github.germanosin.vscaleio.dto;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by germanosin on 10.11.15.
 */
public class ConsumptionList {
    private final Map<Long,Consumption> consumptions;

    public ConsumptionList(Map<Long, Consumption> consumptions) {
        this.consumptions = consumptions;
    }

    public Map<Long, Consumption> getConsumptions() {
        return consumptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsumptionList that = (ConsumptionList) o;

        if (consumptions != null ? !consumptions.equals(that.consumptions) : that.consumptions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return consumptions != null ? consumptions.hashCode() : 0;
    }
}
