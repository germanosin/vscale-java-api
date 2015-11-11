package com.github.germanosin.vscaleio.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by germanosin on 10.11.15.
 */
public class ScaletPlan {
    @SerializedName("rplan")
    private final String plan;

    public String getPlan() {
        return plan;
    }

    public ScaletPlan(String plan) {
        this.plan = plan;
    }

    public static ScaletPlan fromString(String name) {
        return new ScaletPlan(name);
    }
}
