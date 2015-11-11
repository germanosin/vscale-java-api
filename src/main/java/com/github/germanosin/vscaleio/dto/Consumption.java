package com.github.germanosin.vscaleio.dto;

import java.util.Map;

/**
 * Created by germanosin on 10.11.15.
 */
public class Consumption {
    private final Map<String,ConsumptionItem> items;
    private final Long total;

    public Consumption(Map<String, ConsumptionItem> items, Long total) {
        this.items = items;
        this.total = total;
    }

    public Map<String, ConsumptionItem> getItems() {
        return items;
    }

    public Long getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consumption that = (Consumption) o;

        if (items != null ? !items.equals(that.items) : that.items != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = items != null ? items.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }
}
