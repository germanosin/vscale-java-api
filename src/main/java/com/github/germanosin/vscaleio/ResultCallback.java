package com.github.germanosin.vscaleio;

/**
 *
 */
public interface ResultCallback<T> {
    /** Successful HTTP response. */
    void onResponse(T result);
    /** Invoked when not successful status or network or unexpected exception occurred during the HTTP request. */
    void onFailure(Throwable error);
}
