package com.ufsc.trabalho.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(value = EntityNotFoundException.class)
	public ResponseEntity<String> entityNotFoundException(EntityNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public ResponseEntity<String> emptyResultDataAccessException(EmptyResultDataAccessException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<String> dataIntegrityViolationException(
			DataIntegrityViolationException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<String> illegalArgumentException(
			IllegalArgumentException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	}

}
