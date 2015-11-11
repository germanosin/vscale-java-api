package com.github.germanosin.vscaleio.dto;

/**
 * Created by germanosin on 10.11.15.
 */
public class ScaletPassword {
    private final String password;

    public ScaletPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public static ScaletPassword fromString(String password) {
        return new ScaletPassword(password);
    }
}
