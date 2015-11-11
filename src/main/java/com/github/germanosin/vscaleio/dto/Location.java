package com.github.germanosin.vscaleio.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by germanosin on 10.11.15.
 */
public class Location {
    private String id;

    private Boolean active;

    @SerializedName("private_networking")
    private Boolean privateNetworking;

    private String description;

    @SerializedName("rplans")
    private List<String> plans;

    public String getId() {
        return id;
    }

    public Boolean getActive() {
        return active;
    }

    public Boolean getPrivateNetworking() {
        return privateNetworking;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getPlans() {
        return plans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (active != null ? !active.equals(location.active) : location.active != null) return false;
        if (description != null ? !description.equals(location.description) : location.description != null)
            return false;
        if (id != null ? !id.equals(location.id) : location.id != null) return false;
        if (plans != null ? !plans.equals(location.plans) : location.plans != null) return false;
        if (privateNetworking != null ? !privateNetworking.equals(location.privateNetworking) : location.privateNetworking != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
