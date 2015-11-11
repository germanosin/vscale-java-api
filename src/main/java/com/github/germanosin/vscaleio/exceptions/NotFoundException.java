package com.github.germanosin.vscaleio.exceptions;

import retrofit.Response;

/**
 * Created by germanosin on 11.11.15.
 */
public class NotFoundException extends VscaleException {
    public NotFoundException(Response<?> response) {
        super(response);
    }
}
