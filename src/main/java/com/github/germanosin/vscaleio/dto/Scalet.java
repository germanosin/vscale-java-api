package com.github.germanosin.vscaleio.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by germanosin on 10.11.15.
 */
public class Scalet {
    @SerializedName("ctid")
    Long id;
    String hostname;
    String name;
    Boolean locked;
    String location;
    @SerializedName("rplan")
    String plan;
    Boolean active;
    @SerializedName("public_address")
    IpAddress publicAddress;
    @SerializedName("private_address")
    IpAddress privateAddress;
    String status;
    @SerializedName("made_from")
    String madeFrom;

    List<SSHKey> keys;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public IpAddress getPublicAddress() {
        return publicAddress;
    }

    public void setPublicAddress(IpAddress publicAddress) {
        this.publicAddress = publicAddress;
    }

    public IpAddress getPrivateAddress() {
        return privateAddress;
    }

    public void setPrivateAddress(IpAddress privateAddress) {
        this.privateAddress = privateAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMadeFrom() {
        return madeFrom;
    }

    public void setMadeFrom(String madeFrom) {
        this.madeFrom = madeFrom;
    }

    public List<SSHKey> getKeys() {
        return keys;
    }

    public void setKeys(List<SSHKey> keys) {
        this.keys = keys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Scalet scalet = (Scalet) o;

        if (active != null ? !active.equals(scalet.active) : scalet.active != null) return false;
        if (id != null ? !id.equals(scalet.id) : scalet.id != null) return false;
        if (hostname != null ? !hostname.equals(scalet.hostname) : scalet.hostname != null) return false;
        if (location != null ? !location.equals(scalet.location) : scalet.location != null) return false;
        if (locked != null ? !locked.equals(scalet.locked) : scalet.locked != null) return false;
        if (madeFrom != null ? !madeFrom.equals(scalet.madeFrom) : scalet.madeFrom != null) return false;
        if (name != null ? !name.equals(scalet.name) : scalet.name != null) return false;
        if (plan != null ? !plan.equals(scalet.plan) : scalet.plan != null) return false;
        if (privateAddress != null ? !privateAddress.equals(scalet.privateAddress) : scalet.privateAddress != null)
            return false;
        if (publicAddress != null ? !publicAddress.equals(scalet.publicAddress) : scalet.publicAddress != null)
            return false;
        if (status != null ? !status.equals(scalet.status) : scalet.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hostname != null ? hostname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
