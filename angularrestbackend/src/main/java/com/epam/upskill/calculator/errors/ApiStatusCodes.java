package com.epam.upskill.calculator.errors;
/**
 * API Status Codes
 *
 * This class provides the status codes used in the REST API for the Calculator service,
 * including their meanings and usage scenarios.
 */
public class ApiStatusCodes {

    /**
     * 200 OK
     * The request was successful, and the server returned the expected result.
     */
    public static final int STATUS_OK = 200;

    /**
     * 201 Created
     * The request was successful, and a new resource was created.
     */
    public static final int STATUS_CREATED = 201;

    /**
     * 204 No Content
     * The request was successful, but there is no content to return.
     */
    public static final int STATUS_NO_CONTENT = 204;

    /**
     * 400 Bad Request
     * The request could not be understood or was missing required parameters.
     */
    public static final int STATUS_BAD_REQUEST = 400;

    /**
     * 401 Unauthorized
     * Authentication is required and has failed or has not been provided.
     */
    public static final int STATUS_UNAUTHORIZED = 401;

    /**
     * 403 Forbidden
     * The server understood the request but refuses to authorize it.
     */
    public static final int STATUS_FORBIDDEN = 403;

    /**
     * 404 Not Found
     * The requested resource could not be found on the server.
     */
    public static final int STATUS_NOT_FOUND = 404;

    /**
     * 409 Conflict
     * The request could not be completed due to a conflict with the current state of the resource.
     */
    public static final int STATUS_CONFLICT = 409;

    /**
     * 500 Internal Server Error
     * The server encountered an unexpected condition that prevented it from fulfilling the request.
     */
    public static final int STATUS_INTERNAL_SERVER_ERROR = 500;

    /**
     * 503 Service Unavailable
     * The server is currently unable to handle the request due to a temporary overload or maintenance.
     */
    public static final int STATUS_SERVICE_UNAVAILABLE = 503;
}
