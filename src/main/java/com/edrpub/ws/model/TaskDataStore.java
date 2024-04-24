package com.edrpub.ws.model;

import java.util.ArrayList;
import java.util.List;

public class TaskDataStore {

  private static TaskDataStore instance = null;
  private static volatile int counterI = 0;
  private Tasks tasks;

  // make taskdatastore private so all access goes through getInstance()
  private TaskDataStore() {
    // this should only ever be done once
    List<Task> ts = new ArrayList<Task>();
    // populate a task datastore
    for (int i = 0; i < 6; i++) {
      Task t = new Task();
      t.setText("Post-" + i + "-" + t.getId());
      ts.add(t);
    }
    tasks = new Tasks();
    tasks.setTasks(ts);
  }

  /**
   * Get an instance of the DataStore.
   * If this is the first time, it will also initialize using the
   * private constructor, otherwise it will provide access to the singleton object
   *
   * @return
   */
  public static synchronized TaskDataStore getInstance() {
    counterI++;
    if (counterI < 1 || counterI > 1) return instance; else {
      instance = new TaskDataStore();
      return instance;
    }
  }

  /**
   * Get a Task by id from the datastore
   *
   * @param id
   * @return
   * @throws Exception if no match occurs
   */
  public synchronized Task getTask(String id) throws Exception {
    synchronized (tasks) {
      Task w = null;
      if ((w = tasks.getTask(id)) != null) return w;
      throw new Exception("Task Not Found");
    }
  }

  /**
   * Get all Tasks from the datastore
   *
   * @return
   */
  public synchronized Tasks getAllTasks() {
    synchronized (tasks) {
      return tasks;
    }
  }

  /**
   * Delete a Task from the datastore
   *
   * @param id - the id of the Task to delete
   * @throws Exception if no match occurs
   */
  public synchronized Task deleteTask(String id) throws Exception {
    synchronized (tasks) {
      return tasks.remove(id);
    }
  }

  /**
   * Update an existing Task
   *
   * @param id - the id of the Task to update
   * @param w  - A Task containing the values to update
   * @return
   * @throws Exception if no match occurs
   */
  public synchronized Task updateTask(String id, Task w) throws Exception {
    synchronized (tasks) {
      return tasks.update(id, w);
    }
  }

  /**
   * Add a Task to the data store
   * There's no validation or duplicate check here
   *
   * @param w - a Task
   * @return
   */
  public synchronized Task addTask(Task t) {
    synchronized (tasks) {
      tasks.add(t);
      return t;
    }
  }
}
