package com.github.germanosin.vscaleio.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by germanosin on 10.11.15.
 */
public class AccountInfo {
    Long id;
    @SerializedName("actdate")
    private Date activationDate;
    private String country;
    private String email;
    @SerializedName("face_id")
    private Short faceId;
    private String locale;
    private String middleName;
    private String name;
    private String surname;
    private String mobile;
    private Short state;


    public Long getId() {
        return id;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public Short getFaceId() {
        return faceId;
    }

    public String getLocale() {
        return locale;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMobile() {
        return mobile;
    }

    public Short getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountInfo that = (AccountInfo) o;

        if (activationDate != null ? !activationDate.equals(that.activationDate) : that.activationDate != null)
            return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (faceId != null ? !faceId.equals(that.faceId) : that.faceId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (locale != null ? !locale.equals(that.locale) : that.locale != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
