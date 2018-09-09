package com.dept.main.exception;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.dept.main.exception.ExceptionResponse;

@RestController
@ControllerAdvice
public class DepartmentExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static String genericMessage= " exception occured while processing request";
	private static String sqlgenericMessage= " exception occured while getting department  details";
	private static String recordNotFoundMessage= " The requested department record not found";
	
	
	@ExceptionHandler(Exception.class)	
	public final ResponseEntity<ExceptionResponse> handleGenericException(Exception exception, WebRequest request)  {
		ExceptionResponse exceptionResponse = new ExceptionResponse(DepartmentExceptionHandler.genericMessage, exception.getMessage());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(SQLException.class)
	public final ResponseEntity<ExceptionResponse> handleSQLException(SQLException exception, WebRequest request)  {
		ExceptionResponse exceptionResponse = new ExceptionResponse(DepartmentExceptionHandler.sqlgenericMessage, exception.getMessage());		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_MODIFIED);
	}
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleDepartmentNotFounException(DepartmentNotFoundException exception, WebRequest request)  {
		ExceptionResponse exceptionResponse = new ExceptionResponse(DepartmentExceptionHandler.recordNotFoundMessage, request.getDescription(false));		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	

}
