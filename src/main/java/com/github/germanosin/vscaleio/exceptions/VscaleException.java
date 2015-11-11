package com.github.germanosin.vscaleio.exceptions;

import retrofit.Response;

/**
 * Created by germanosin on 11.11.15.
 */
public class VscaleException extends Exception {
    private final int code;
    private final String message;
    private final transient Response<?> response;


    public VscaleException(Response<?> response) {
        super("Vscale " + response.code() + " " + response.message());
        this.code = response.code();
        this.message = response.message();
        this.response = response;
    }

    /** HTTP status code. */
    public int code() {
        return code;
    }

    /** HTTP status message. */
    public String message() {
        return message;
    }

    /**
     * The full HTTP response. This may be null if the exception was serialized.
     */
    public Response<?> response() {
        return response;
    }

    public static VscaleException httpError(Response<?> response) {
        VscaleException exception;
        switch (response.code()) {
            case 400: exception = new BadRequestException(response); break;
            case 401: exception = new UnauthorizedException(response); break;
            case 403: exception = new ForbiddenException(response); break;
            case 404: exception = new NotFoundException(response); break;
            default:exception = new VscaleException(response);
        }
        return exception;
    }
}
