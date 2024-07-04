package com.microservice.metadata.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MetadataExceptionHandler {
	@ExceptionHandler(value = { MetadataException.class })
	public ResponseEntity<Object> handleMetadataApplicationException(MetadataException metadataException) {
		return ResponseEntity.status(metadataException.getHttpStatus()).body(metadataException.getMessage());
	}
}
