package model;

import java.util.ArrayList;

public class TaskList
{
  private ArrayList<Task> tasklist;

  public TaskList()
  {
    tasklist = new ArrayList<>();
  }

  public void add(Task task)
  {
    tasklist.add(task);
  }

  public int getSize()
  {
    return tasklist.size();
  }

}
