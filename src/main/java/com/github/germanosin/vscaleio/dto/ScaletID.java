package com.github.germanosin.vscaleio.dto;

/**
 * Created by germanosin on 10.11.15.
 */
public class ScaletID {
    private final Long id;

    public ScaletID(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public static ScaletID fromId(Long id) {
        return new ScaletID(id);
    }
}
