package com.mark43.utils.constant;

public final class AppConstant {

    private AppConstant() {
    }

    /*
     |--------------------------------------------------------------------------
     | APPLICATION
     |--------------------------------------------------------------------------
     */

    public static final String APP_NAME = "Mark-43";

    public static final String API_VERSION = "/api/v1";

    public static final String DEFAULT_LANGUAGE = "en";

    public static final String TIME_ZONE = "Asia/Kolkata";

    public static final String SYSTEM = "SYSTEM";


    /*
     |--------------------------------------------------------------------------
     | AUTH
     |--------------------------------------------------------------------------
     */

    public static final String BEARER = "Bearer ";

    public static final String AUTHORIZATION = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String JWT = "JWT";

    public static final String REFRESH_TOKEN = "REFRESH_TOKEN";


    /*
     |--------------------------------------------------------------------------
     | ROLE
     |--------------------------------------------------------------------------
     */

    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    public static final String ROLE_RECRUITER = "ROLE_RECRUITER";

    public static final String ROLE_JOB_SEEKER = "ROLE_JOB_SEEKER";


    /*
     |--------------------------------------------------------------------------
     | USER STATUS
     |--------------------------------------------------------------------------
     */

    public static final String ACTIVE = "ACTIVE";

    public static final String INACTIVE = "INACTIVE";

    public static final String BLOCKED = "BLOCKED";

    public static final String DELETED = "DELETED";


    /*
     |--------------------------------------------------------------------------
     | RESPONSE MESSAGE
     |--------------------------------------------------------------------------
     */

    public static final String SUCCESS = "Success";

    public static final String FAILED = "Failed";

    public static final String CREATED = "Created Successfully";

    public static final String UPDATED = "Updated Successfully";

    public static final String DELETED_SUCCESSFULLY =
            "Deleted Successfully";

    public static final String FETCHED_SUCCESSFULLY =
            "Fetched Successfully";


    /*
     |--------------------------------------------------------------------------
     | AUTH MESSAGE
     |--------------------------------------------------------------------------
     */

    public static final String LOGIN_SUCCESS =
            "Login Successfully";

    public static final String REGISTER_SUCCESS =
            "Registration Successfully";

    public static final String INVALID_CREDENTIALS =
            "Invalid Credentials";

    public static final String ACCESS_DENIED =
            "Access Denied";

    public static final String UNAUTHORIZED =
            "Unauthorized Access";

    public static final String TOKEN_EXPIRED =
            "Token Expired";

    public static final String INVALID_TOKEN =
            "Invalid Token";


    /*
     |--------------------------------------------------------------------------
     | VALIDATION MESSAGE
     |--------------------------------------------------------------------------
     */

    public static final String REQUIRED =
            "Field is required";

    public static final String INVALID_EMAIL =
            "Invalid Email";

    public static final String INVALID_PHONE =
            "Invalid Phone Number";

    public static final String PASSWORD_NOT_MATCH =
            "Password does not match";


    /*
     |--------------------------------------------------------------------------
     | FILE
     |--------------------------------------------------------------------------
     */

    public static final long MAX_FILE_SIZE =
            5 * 1024 * 1024;

    public static final String PDF =
            "application/pdf";

    public static final String PNG =
            "image/png";

    public static final String JPG =
            "image/jpg";

    public static final String JPEG =
            "image/jpeg";


    /*
     |--------------------------------------------------------------------------
     | PAGINATION
     |--------------------------------------------------------------------------
     */

    public static final int DEFAULT_PAGE = 0;

    public static final int DEFAULT_SIZE = 10;

    public static final int MAX_PAGE_SIZE = 100;

    public static final String DEFAULT_SORT_BY =
            "createdAt";

    public static final String ASC = "asc";

    public static final String DESC = "desc";


    /*
     |--------------------------------------------------------------------------
     | DATE FORMAT
     |--------------------------------------------------------------------------
     */

    public static final String DATE_FORMAT =
            "dd-MM-yyyy";

    public static final String DATE_TIME_FORMAT =
            "dd-MM-yyyy HH:mm:ss";

    public static final String TIME_FORMAT =
            "HH:mm:ss";


    /*
     |--------------------------------------------------------------------------
     | CACHE
     |--------------------------------------------------------------------------
     */

    public static final String USER_CACHE =
            "USER_CACHE";

    public static final String JOB_CACHE =
            "JOB_CACHE";


    /*
     |--------------------------------------------------------------------------
     | HEADER
     |--------------------------------------------------------------------------
     */

    public static final String REQUEST_ID =
            "X-Request-Id";

    public static final String DEVICE_ID =
            "X-Device-Id";


    /*
     |--------------------------------------------------------------------------
     | REGEX
     |--------------------------------------------------------------------------
     */

    public static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static final String PHONE_REGEX =
            "^[6-9]\\d{9}$";


    /*
     |--------------------------------------------------------------------------
     | OTP
     |--------------------------------------------------------------------------
     */

    public static final int OTP_LENGTH = 6;

    public static final int OTP_EXPIRATION_MINUTES = 5;


    /*
     |--------------------------------------------------------------------------
     | JOB
     |--------------------------------------------------------------------------
     */

    public static final String JOB_OPEN = "OPEN";

    public static final String JOB_CLOSED = "CLOSED";

    public static final String JOB_DRAFT = "DRAFT";


    /*
     |--------------------------------------------------------------------------
     | APPLICATION STATUS
     |--------------------------------------------------------------------------
     */

    public static final String APPLIED = "APPLIED";

    public static final String SHORTLISTED =
            "SHORTLISTED";

    public static final String REJECTED = "REJECTED";

    public static final String HIRED = "HIRED";
}