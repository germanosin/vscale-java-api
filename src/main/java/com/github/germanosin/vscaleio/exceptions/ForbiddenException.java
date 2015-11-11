package com.github.germanosin.vscaleio.exceptions;

import retrofit.Response;

/**
 * Created by germanosin on 11.11.15.
 */
public class ForbiddenException extends VscaleException {
    public ForbiddenException(Response<?> response) {
        super(response);
    }
}
