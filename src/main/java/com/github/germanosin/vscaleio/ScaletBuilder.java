package com.github.germanosin.vscaleio;

import com.github.germanosin.vscaleio.dto.NewScalet;
import com.github.germanosin.vscaleio.dto.Scalet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by germanosin on 11.11.15.
 */
public class ScaletBuilder {
    private final Scalet scalet = new Scalet();
    private boolean doStart = false;
    private List<Long> keys;
    private String password;

    public ScaletBuilder makeFrom(String makeFrom) {
        this.scalet.setMadeFrom(makeFrom);
        return this;
    }

    public ScaletBuilder doStart(boolean doStart) {
        this.doStart = doStart;
        return this;
    }

    public ScaletBuilder password(String password) {
        this.password = password;
        return this;
    }

    public ScaletBuilder keys(List<Long> keys) {
        this.keys = keys;
        return this;
    }

    public ScaletBuilder addKey(Long key) {
        if (this.keys==null) this.keys = new ArrayList<Long>();
        this.keys.add(key);
        return this;
    }

    public ScaletBuilder plan(String plan) {
        this.scalet.setPlan(plan);
        return this;
    }

    public ScaletBuilder name(String name) {
        this.scalet.setName(name);
        return this;
    }

    public ScaletBuilder location(String location) {
        this.scalet.setLocation(location);
        return this;
    }

    public NewScalet build() {
        if (this.keys!=null) {
            return NewScalet.fromScalet(this.scalet, this.keys, this.doStart);
        } else {
            return NewScalet.fromScalet(this.scalet, this.password, this.doStart);
        }
    }

}
