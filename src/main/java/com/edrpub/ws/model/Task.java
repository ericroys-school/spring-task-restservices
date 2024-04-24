package com.edrpub.ws.model;

import java.util.Date;
import java.util.UUID;

public class Task {

  private String id;
  private String text;
  private boolean isCompleted;
  private Date createdAt;

  public Task() {
    this.id = UUID.randomUUID().toString();
    this.createdAt = new Date();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isCompleted() {
    return isCompleted;
  }

  public void setCompleted(boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}
