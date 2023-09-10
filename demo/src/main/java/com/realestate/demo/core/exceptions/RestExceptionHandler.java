package com.realestate.demo.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.realestate.demo.core.utils.exceptions.BusinessException;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleBusinessException(BusinessException businessException)
	{
		return businessException.getMessage();
	}

}
