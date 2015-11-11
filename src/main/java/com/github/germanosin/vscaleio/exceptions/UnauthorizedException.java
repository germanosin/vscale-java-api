package com.github.germanosin.vscaleio.exceptions;

import retrofit.Response;

/**
 * Created by germanosin on 11.11.15.
 */
public class UnauthorizedException extends VscaleException {
    public UnauthorizedException(Response<?> response) {
        super(response);
    }
}
