package com.github.germanosin.vscaleio.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by germanosin on 10.11.15.
 */
public class Image {
    private String id;
    private Boolean active;
    private String description;
    private List<String> locations;
    @SerializedName("rplans")
    private List<String> plans;

    public String getId() {
        return id;
    }

    public Boolean getActive() {
        return active;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getLocations() {
        return locations;
    }

    public List<String> getPlans() {
        return plans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (active != null ? !active.equals(image.active) : image.active != null) return false;
        if (description != null ? !description.equals(image.description) : image.description != null) return false;
        if (id != null ? !id.equals(image.id) : image.id != null) return false;
        if (locations != null ? !locations.equals(image.locations) : image.locations != null) return false;
        if (plans != null ? !plans.equals(image.plans) : image.plans != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
