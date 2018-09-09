package com.dept.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException {
	
	
	
	
	private static final long serialVersionUID = -503153764948817010L;

	public DepartmentNotFoundException(String message)  {
		
				super(message);
	}
	
	

}
