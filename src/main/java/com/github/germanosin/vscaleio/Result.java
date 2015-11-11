package com.github.germanosin.vscaleio;

import com.github.germanosin.vscaleio.exceptions.VscaleException;

import java.io.IOException;

/**
 *
 */
public interface Result<T> {
    T get() throws IOException, VscaleException;
    void cancel();
    void enqueue(ResultCallback<T> callback);
    Result<T> clone();
}
