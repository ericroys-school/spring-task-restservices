package com.edrpub.ws.model;

public class ValidationException extends RuntimeException {

  private static final long serialVersionUID = -4116519033749794189L;

  public ValidationException(String message) {
    super(message);
  }
}
