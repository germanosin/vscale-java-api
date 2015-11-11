package com.github.germanosin.vscaleio.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by germanosin on 10.11.15.
 */
public class ConsumptionItem {
    private final Long count;
    @SerializedName("summ")
    private final Long sum;

    public ConsumptionItem(Long count, Long sum) {
        this.count = count;
        this.sum = sum;
    }

    public Long getCount() {
        return count;
    }

    public Long getSum() {
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsumptionItem that = (ConsumptionItem) o;

        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = count != null ? count.hashCode() : 0;
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        return result;
    }
}
