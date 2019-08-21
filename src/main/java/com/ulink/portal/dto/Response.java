package com.ulink.portal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

	private Boolean statusCode;

	private String message;

	private T body;

	private int httpStatus;

	private String jwt;

	public Response() {
	}

	public Response(int httpStatus, Boolean statusCode, String message, T body) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.body = body;
        this.httpStatus = httpStatus;
    }

	public Boolean getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Boolean statusCode) {
		this.statusCode = statusCode;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return "Response [statusCode=" + statusCode + ", message=" + message + ", body=" + body + ", httpStatus="
                + httpStatus + ", jwt=" + jwt + "]";
    }

}
