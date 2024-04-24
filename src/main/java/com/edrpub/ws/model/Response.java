package com.edrpub.ws.model;

/**
 * Response is the typical response to any api call.
 *
 */
public class Response {

  private int code;
  private String message;
  private String developerMessage;
  private String link;

  /**
   * Construct ARResponse object
   * @param code - an Http status code
   * @param msg - main body of the response
   * @param devMsg - additional message for verbose messaging
   * @param link - the url of the service call
   */
  public Response(int code, String msg, String devMsg, String link) {
    this.code = code;
    this.message = msg;
    this.developerMessage = devMsg;
    this.link = link;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDeveloperMessage() {
    return developerMessage;
  }

  public void setDeveloperMessage(String developerMessage) {
    this.developerMessage = developerMessage;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}
