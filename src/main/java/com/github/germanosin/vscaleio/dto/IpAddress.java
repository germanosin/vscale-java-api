package com.github.germanosin.vscaleio.dto;

/**
 * Created by germanosin on 10.11.15.
 */
public class IpAddress {
    private String address;
    private String netmask;
    private String gateway;

    public String getAddress() {
        return address;
    }

    public String getNetmask() {
        return netmask;
    }

    public String getGateway() {
        return gateway;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IpAddress ipAddress = (IpAddress) o;

        if (address != null ? !address.equals(ipAddress.address) : ipAddress.address != null) return false;
        if (gateway != null ? !gateway.equals(ipAddress.gateway) : ipAddress.gateway != null) return false;
        if (netmask != null ? !netmask.equals(ipAddress.netmask) : ipAddress.netmask != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (netmask != null ? netmask.hashCode() : 0);
        result = 31 * result + (gateway != null ? gateway.hashCode() : 0);
        return result;
    }
}
