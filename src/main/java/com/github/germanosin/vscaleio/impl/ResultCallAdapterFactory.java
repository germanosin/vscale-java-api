package com.github.germanosin.vscaleio.impl;

import com.github.germanosin.vscaleio.Result;
import retrofit.Call;
import retrofit.CallAdapter;
import retrofit.Retrofit;


import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by germanosin on 11.11.15.
 */
public class ResultCallAdapterFactory implements CallAdapter.Factory {
    @Override
    public CallAdapter<?> get(Type type, Annotation[] annotations, Retrofit retrofit) {
        Type rawType = Utils.getSingleParameterUpperBound((ParameterizedType) type);
        return new ResultCallAdapter(rawType);
    }

    static final class ResultCallAdapter implements CallAdapter<Result<?>> {

        private final Type responseType;

        ResultCallAdapter(Type responseType) {
            this.responseType = responseType;
        }

        @Override
        public Type responseType() {
            return this.responseType;
        }

        @Override
        public <R> Result<?> adapt(Call<R> call) {
            return new ResultImpl<R>(call);
        }
    }
}
