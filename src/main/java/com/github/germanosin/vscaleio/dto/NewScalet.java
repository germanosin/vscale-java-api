package com.github.germanosin.vscaleio.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by germanosin on 10.11.15.
 */
public class NewScalet {
    private final String makeFrom;
    @SerializedName("rplan")
    private final String plan;
    private final Boolean doStart;
    private final String name;
    private final List<Long> keys;
    private final String password;
    private final String location;

    public NewScalet(String makeFrom, String plan, Boolean doStart, String name, List<Long> keys, String location) {
        this.makeFrom = makeFrom;
        this.plan = plan;
        this.doStart = doStart;
        this.name = name;
        this.keys = keys;
        this.location = location;
        this.password = null;
    }

    public NewScalet(String makeFrom, String plan, Boolean doStart, String name, String password, String location) {
        this.makeFrom = makeFrom;
        this.plan = plan;
        this.doStart = doStart;
        this.name = name;
        this.password = password;
        this.location = location;
        this.keys = null;
    }

    public String getMakeFrom() {
        return makeFrom;
    }

    public String getPlan() {
        return plan;
    }

    public Boolean getDoStart() {
        return doStart;
    }

    public String getName() {
        return name;
    }

    public List<Long> getKeys() {
        return keys;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
    }

    public static NewScalet fromScalet(Scalet scalet, List<Long> keys, boolean doStart) {

        return new NewScalet(
                scalet.getMadeFrom(),
                scalet.getPlan(),
                doStart,
                scalet.getName(),
                keys,
                scalet.getLocation()
        );
    }

    public static NewScalet fromScalet(Scalet scalet, String password, boolean doStart) {

        return new NewScalet(
                scalet.getMadeFrom(),
                scalet.getPlan(),
                doStart,
                scalet.getName(),
                password,
                scalet.getLocation()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewScalet newScalet = (NewScalet) o;

        if (doStart != null ? !doStart.equals(newScalet.doStart) : newScalet.doStart != null) return false;
        if (keys != null ? !keys.equals(newScalet.keys) : newScalet.keys != null) return false;
        if (location != null ? !location.equals(newScalet.location) : newScalet.location != null) return false;
        if (makeFrom != null ? !makeFrom.equals(newScalet.makeFrom) : newScalet.makeFrom != null) return false;
        if (name != null ? !name.equals(newScalet.name) : newScalet.name != null) return false;
        if (password != null ? !password.equals(newScalet.password) : newScalet.password != null) return false;
        if (plan != null ? !plan.equals(newScalet.plan) : newScalet.plan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = makeFrom != null ? makeFrom.hashCode() : 0;
        result = 31 * result + (plan != null ? plan.hashCode() : 0);
        result = 31 * result + (doStart != null ? doStart.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (keys != null ? keys.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
