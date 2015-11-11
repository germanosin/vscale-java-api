package com.github.germanosin.vscaleio.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by germanosin on 10.11.15.
 */
public class Balance {
    private Long balance;
    private Long bonus;
    private String status;
    private Long summ;
    private Long unpaid;
    @SerializedName("user_id")
    private Long userId;

    public Balance() {
    }

    public Long getBalance() {
        return balance;
    }

    public Long getBonus() {
        return bonus;
    }

    public String getStatus() {
        return status;
    }

    public Long getSumm() {
        return summ;
    }

    public Long getUnpaid() {
        return unpaid;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Balance balance1 = (Balance) o;

        if (balance != null ? !balance.equals(balance1.balance) : balance1.balance != null) return false;
        if (bonus != null ? !bonus.equals(balance1.bonus) : balance1.bonus != null) return false;
        if (status != null ? !status.equals(balance1.status) : balance1.status != null) return false;
        if (summ != null ? !summ.equals(balance1.summ) : balance1.summ != null) return false;
        if (unpaid != null ? !unpaid.equals(balance1.unpaid) : balance1.unpaid != null) return false;
        if (userId != null ? !userId.equals(balance1.userId) : balance1.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = balance != null ? balance.hashCode() : 0;
        result = 31 * result + (bonus != null ? bonus.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (summ != null ? summ.hashCode() : 0);
        result = 31 * result + (unpaid != null ? unpaid.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
