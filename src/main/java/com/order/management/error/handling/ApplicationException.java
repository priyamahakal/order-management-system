package com.order.management.error.handling;

public class ApplicationException extends Exception {
	private String errorCode;
	private String msg;

	public ApplicationException(String errorCode, String msg) {
		this.errorCode = errorCode;
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return msg;
	}

}
