package com.github.germanosin.vscaleio.impl;

import com.github.germanosin.vscaleio.ResultCallback;
import com.github.germanosin.vscaleio.exceptions.VscaleException;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by germanosin on 11.11.15.
 */
public class CallbackHandler<T> implements Callback<T> {

    private final ResultCallback<T> resultCallback;

    public CallbackHandler(ResultCallback<T> resultCallback) {
        this.resultCallback = resultCallback;
    }

    @Override
    public void onResponse(Response<T> response, Retrofit retrofit) {
        if (response.isSuccess()) {
            resultCallback.onResponse(response.body());
        } else {
            resultCallback.onFailure(VscaleException.httpError(response));
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        resultCallback.onFailure(throwable);
    }
}
