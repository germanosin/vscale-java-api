package com.github.germanosin.vscaleio.dto;

/**
 * Created by germanosin on 10.11.15.
 */
public class SSHKey {
    Long id;
    String name;
    String key;

    public SSHKey(String name, String key) {
        this.name = name;
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SSHKey sshKey = (SSHKey) o;

        if (id != null ? !id.equals(sshKey.id) : sshKey.id != null) return false;
        if (key != null ? !key.equals(sshKey.key) : sshKey.key != null) return false;
        if (name != null ? !name.equals(sshKey.name) : sshKey.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
