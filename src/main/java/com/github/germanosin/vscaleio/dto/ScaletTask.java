package com.github.germanosin.vscaleio.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by germanosin on 10.11.15.
 */
public class ScaletTask {

    String id;
    Boolean done;
    Long scaletId;
    String location;
    @SerializedName("d_insert")
    Date insertDate;
    @SerializedName("d_start")
    Date startDate;
    @SerializedName("d_end")
    String endDate;
    String method;
    Boolean error;

    public String getId() {
        return id;
    }

    public Boolean getDone() {
        return done;
    }

    public Long getScaletId() {
        return scaletId;
    }

    public String getLocation() {
        return location;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getMethod() {
        return method;
    }

    public Boolean getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScaletTask that = (ScaletTask) o;

        if (done != null ? !done.equals(that.done) : that.done != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (error != null ? !error.equals(that.error) : that.error != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (insertDate != null ? !insertDate.equals(that.insertDate) : that.insertDate != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (method != null ? !method.equals(that.method) : that.method != null) return false;
        if (scaletId != null ? !scaletId.equals(that.scaletId) : that.scaletId != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
