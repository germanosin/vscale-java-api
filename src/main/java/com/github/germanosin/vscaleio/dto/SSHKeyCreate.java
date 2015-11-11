package com.github.germanosin.vscaleio.dto;

/**
 * Created by germanosin on 10.11.15.
 */
public class SSHKeyCreate {

    private final String name;
    private final String key;

    public SSHKeyCreate(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public static SSHKeyCreate fromSshKey(SSHKey key) {
        return new SSHKeyCreate(key.getName(), key.getKey());
    }
}
