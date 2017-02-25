package com.ercanpinar.news.service.response;

/**
 * Created by ercanpinar on 04/02/2017.
 */

/**
 * ******** BaseResponse ********
 */
public class BaseResponse {
    /**
     * ******** Declare Used Variables ********
     */
    private String errorCode;
    private String errorMessage;
    private String successMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
}
