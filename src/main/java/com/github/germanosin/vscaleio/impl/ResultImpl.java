package com.github.germanosin.vscaleio.impl;

import com.github.germanosin.vscaleio.Result;
import com.github.germanosin.vscaleio.ResultCallback;
import com.github.germanosin.vscaleio.exceptions.VscaleException;
import retrofit.Call;
import retrofit.Response;

import java.io.IOException;

/**
 * Created by germanosin on 11.11.15.
 */
public class ResultImpl<T> implements Result<T> {
    private final Call<T> call;

    public ResultImpl(Call<T> call) {
        this.call = call;
    }

    @Override
    public T get() throws IOException, VscaleException {
        Response<T> response = this.call.execute();
        if (response.isSuccess()) {
            return response.body();
        } else {
            throw VscaleException.httpError(response);
        }
    }

    @Override
    public void cancel() {
        this.call.cancel();
    }

    @Override
    public void enqueue(ResultCallback<T> callback) {
        this.call.enqueue(new CallbackHandler<T>(callback));
    }

    @Override
    public Result<T> clone() {
        return new ResultImpl<T>(this.call.clone());
    }

    public Call<T> getCall() {
        return call;
    }
}
