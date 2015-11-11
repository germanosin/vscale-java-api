package com.github.germanosin.vscaleio.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by germanosin on 10.11.15.
 */
public class Payment {

    public enum State {
        NOTPAID(0), CONDITIONALLYPAID(1), PAID(2);

        private final int key;

        State(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public static State fromKey(int key) {
            for(State state : State.values()) {
                if(state.getKey() == key) {
                    return state;
                }
            }
            return null;
        }
    }

    public enum Type {
        CARD(170), PAYPAL(200);

        private final int key;

        Type(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public static Type fromKey(int key) {
            for(Type type : Type.values()) {
                if(type.getKey() == key) {
                    return type;
                }
            }
            return null;
        }
    }

    private Long id;
    private Date created;
    @SerializedName("desc")
    private String description;
    @SerializedName("is_bonus")
    private Short isBonus;
    private Long price;
    private Short state;
    private Short type;

    public Long getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    public String getDescription() {
        return description;
    }

    public Short getIsBonus() {
        return isBonus;
    }

    public Boolean isBonus() {
        return this.isBonus!=0;
    }

    public Long getPrice() {
        return price;
    }

    public State getState() {
        return State.fromKey(this.state);
    }

    public Type getType() {
        return Type.fromKey(this.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (created != null ? !created.equals(payment.created) : payment.created != null) return false;
        if (description != null ? !description.equals(payment.description) : payment.description != null) return false;
        if (id != null ? !id.equals(payment.id) : payment.id != null) return false;
        if (isBonus != null ? !isBonus.equals(payment.isBonus) : payment.isBonus != null) return false;
        if (price != null ? !price.equals(payment.price) : payment.price != null) return false;
        if (state != null ? !state.equals(payment.state) : payment.state != null) return false;
        if (type != null ? !type.equals(payment.type) : payment.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
