package model;

import java.util.ArrayList;

/**
 * TaskList class
 */
public class TaskList
{
  private ArrayList<Task> tasklist;

  /**
   * TaskList constructor
   */
  public TaskList()
  {
    tasklist = new ArrayList<>();
  }

  /**
   * add method for adding Tasks to Task List
   * @param task task to be add
   */
  public void add(Task task)
  {
    tasklist.add(task);
  }

  /**
   * get method fro size of task list
   * @return size of task list
   */
  public int getSize()
  {
    return tasklist.size();
  }

}
