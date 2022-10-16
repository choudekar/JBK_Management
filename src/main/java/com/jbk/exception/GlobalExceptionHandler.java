package com.jbk.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		HashMap<String,Object> map = new HashMap<>();
		
		//map.put("Time",new Date());
		
		/*
		 * ex.getBindingResult().getFieldErrors().forEach(error ->{
		 * map.put(error.getField(),error.getDefaultMessage());});
		 * 
		 * */
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			map.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		return map;
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String>NotFoundEx(NotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(BatchIsNotValidException.class)
	public ResponseEntity<String> batchIsNotValidEx(BatchIsNotValidException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(StaffDoesNotExistException.class)
	public ResponseEntity<String> staffDoesNotExistEx(StaffDoesNotExistException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(InvalidInfoException.class)
	public ResponseEntity<String> invalidInfoEx(InvalidInfoException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
}
