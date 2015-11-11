package com.github.germanosin.vscaleio.dto;

import java.util.List;

/**
 * Created by germanosin on 10.11.15.
 */
public class ScaletKeys {
    private final List<Long> keys;

    public ScaletKeys(List<Long> keys) {
        this.keys = keys;
    }

    public List<Long> getKeys() {
        return keys;
    }
}
