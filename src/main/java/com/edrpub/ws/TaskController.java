package com.edrpub.ws;

import com.edrpub.ws.model.ExceptionResponse;
import com.edrpub.ws.model.Task;
import com.edrpub.ws.model.TaskDataStore;
import com.edrpub.ws.model.Tasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  private static final Logger log = LoggerFactory.getLogger(
    TaskController.class
  );

  @RequestMapping(value = "/api/tasks", method = RequestMethod.GET)
  public Tasks getTasks() {
    return TaskDataStore.getInstance().getAllTasks();
  }

  @RequestMapping(value = "/api/tasks/{id}", method = RequestMethod.GET)
  public Task getTask(@PathVariable @NonNull String id) {
    try {
      return TaskDataStore.getInstance().getTask(id);
    } catch (Exception e) {
      throw new ExceptionResponse(e);
    }
  }

  @RequestMapping(value = "/api/tasks/{id}", method = RequestMethod.DELETE)
  public Task deleteTask(@PathVariable @NonNull String id) {
    try {
      log.info("Delete id: " + id);
      return TaskDataStore.getInstance().deleteTask(id);
    } catch (Exception e) {
      throw new ExceptionResponse(e);
    }
  }

  @RequestMapping(value = "/api/tasks/{id}", method = RequestMethod.PUT)
  public Task updateTask(
    @PathVariable @NonNull String id,
    @RequestBody Task task
  ) {
    try {
      return TaskDataStore.getInstance().updateTask(id, task);
    } catch (Exception e) {
      throw new ExceptionResponse(e);
    }
  }

  @RequestMapping(
    value = "/api/tasks/{id}/markcomplete",
    method = RequestMethod.PUT
  )
  public Task completeTask(@PathVariable @NonNull String id) {
    try {
      Task t = TaskDataStore.getInstance().getTask(id);
      t.setCompleted(true);
      return TaskDataStore.getInstance().updateTask(t.getId(), t);
    } catch (Exception e) {
      throw new ExceptionResponse(e);
    }
  }

  @RequestMapping(value = "/api/tasks", method = RequestMethod.POST)
  public Task createTask(@RequestBody @NonNull Task task) {
    return TaskDataStore.getInstance().addTask(task);
  }
}
