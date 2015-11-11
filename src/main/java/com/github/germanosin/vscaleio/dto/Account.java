package com.github.germanosin.vscaleio.dto;

import java.util.Date;

/**
 * Created by germanosin on 10.11.15.
 */
public class Account {
    AccountInfo info;
    String status;

    public Long getId() {
        return info.getId();
    }

    public Date getActivationDate() {
        return info.getActivationDate();
    }

    public String getCountry() {
        return info.getCountry();
    }

    public String getEmail() {
        return info.getEmail();
    }

    public Short getFaceId() {
        return info.getFaceId();
    }

    public String getLocale() {
        return info.getLocale();
    }

    public String getMiddleName() {
        return info.getMiddleName();
    }

    public String getName() {
        return info.getName();
    }

    public String getSurname() {
        return info.getSurname();
    }

    public String getMobile() {
        return info.getMobile();
    }

    public Short getState() {
        return info.getState();
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (info != null ? !info.equals(account.info) : account.info != null) return false;
        if (status != null ? !status.equals(account.status) : account.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = info != null ? info.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
