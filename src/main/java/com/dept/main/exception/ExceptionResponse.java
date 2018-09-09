package com.dept.main.exception;

public class ExceptionResponse {
	
	private String message;
	private String exceptionDetails;
	
	public ExceptionResponse(String message, String exceptionDetails)  {
		super();
		this.message = message;
		this.exceptionDetails = exceptionDetails;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExceptionDetails() {
		return exceptionDetails;
	}

	public void setExceptionDetails(String exceptionDetails) {
		this.exceptionDetails = exceptionDetails;
	}
	
	

}
