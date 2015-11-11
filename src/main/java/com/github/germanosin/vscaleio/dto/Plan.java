package com.github.germanosin.vscaleio.dto;

import java.util.List;

/**
 * Created by germanosin on 10.11.15.
 */
public class Plan {
    private String id;
    private Short cpus;
    private Short memory;
    private Short addresses;
    private Integer disk;
    private Integer network;

    private List<String> locations;

    public String getId() {
        return id;
    }

    public Short getCpus() {
        return cpus;
    }

    public Short getMemory() {
        return memory;
    }

    public Short getAddresses() {
        return addresses;
    }

    public Integer getDisk() {
        return disk;
    }

    public Integer getNetwork() {
        return network;
    }

    public List<String> getLocations() {
        return locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        if (addresses != null ? !addresses.equals(plan.addresses) : plan.addresses != null) return false;
        if (cpus != null ? !cpus.equals(plan.cpus) : plan.cpus != null) return false;
        if (disk != null ? !disk.equals(plan.disk) : plan.disk != null) return false;
        if (id != null ? !id.equals(plan.id) : plan.id != null) return false;
        if (locations != null ? !locations.equals(plan.locations) : plan.locations != null) return false;
        if (memory != null ? !memory.equals(plan.memory) : plan.memory != null) return false;
        if (network != null ? !network.equals(plan.network) : plan.network != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
