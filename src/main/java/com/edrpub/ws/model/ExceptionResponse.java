package com.edrpub.ws.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ExceptionResponse
 * Ensure all thrown errors are handled via our
 * exception handler
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionResponse extends RuntimeException {

  private static final long serialVersionUID = 5999706507917788427L;

  public ExceptionResponse(Throwable t) {
    super(t.getMessage());
  }
}
