package org.example.http.framework.exception;

public class RequestParametersException extends ServerException{
    public RequestParametersException() {
    }

    public RequestParametersException(String message) {
        super(message);
    }

    public RequestParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestParametersException(Throwable cause) {
        super(cause);
    }

    public RequestParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
