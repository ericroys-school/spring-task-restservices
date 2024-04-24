package com.edrpub.ws.model;

import java.util.ArrayList;
import java.util.List;

public class Tasks {

  private List<Task> tasks = new ArrayList<Task>();

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public Tasks() {}

  public Task getTask(String id) {
    for (Task w : tasks) if (w.getId().equals(id)) return w;
    return null;
  }

  public Task remove(String id) throws Exception {
    Task dw = null;
    for (Task w : tasks) {
      if (w.getId().equals(id)) {
        dw = w;
        break;
      }
    }
    if (dw != null) {
      tasks.remove(dw);
      return dw;
    }
    throw new Exception("Task not found [" + id + "]");
  }

  public Task update(String id, Task task) throws Exception {
    for (Task w : tasks) {
      if (w.getId().equals(id)) {
        w = task;
        return w;
      }
    }
    throw new Exception("Task [" + id + "] not found");
  }

  public Task add(Task w) {
    if (w != null) {
      tasks.add(w);
      return w;
    }
    return null;
  }
}
