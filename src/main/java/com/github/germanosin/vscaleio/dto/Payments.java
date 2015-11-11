package com.github.germanosin.vscaleio.dto;

import java.util.List;

/**
 * Created by germanosin on 10.11.15.
 */
public class Payments {
    List<Payment> items;
    String status;

    public List<Payment> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payments payments = (Payments) o;

        if (items != null ? !items.equals(payments.items) : payments.items != null) return false;
        if (status != null ? !status.equals(payments.status) : payments.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = items != null ? items.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
