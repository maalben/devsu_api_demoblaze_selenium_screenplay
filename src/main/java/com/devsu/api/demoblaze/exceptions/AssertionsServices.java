package com.devsu.api.demoblaze.exceptions;

public class AssertionsServices extends AssertionError {

    private static final long serialVersionUID = 1L;

    public static final String THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED = "The status code services response is not expected";

    public static final String THE_SERVICE_RESPONSE_IS_NOT_EMPTY = "The service response is not empty";
    public static final String THE_MESSAGE_ERROR_IS_NOT_EXPECTED = "The message error is not expected";
    public static final String THE_LOGIN_IS_NOT_SUCCESSFUL = "The login is not successful";
    public static final String SCHEMA_SERVICE_IS_NOT_EXPECTED = "Schema service response is not expected";

    public AssertionsServices(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionsServices(String message) {
        super(message);
    }

}
