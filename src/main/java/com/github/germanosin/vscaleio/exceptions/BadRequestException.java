package com.github.germanosin.vscaleio.exceptions;

import retrofit.Response;

/**
 * Created by germanosin on 11.11.15.
 */
public class BadRequestException extends VscaleException {
    public BadRequestException(Response<?> response) {
        super(response);
    }
}
