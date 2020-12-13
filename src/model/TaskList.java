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

  public ArrayList<Task> getTasks()
  {
    return tasklist;
  }

  public int getSize()
  {
    return tasklist.size();
  }

  public Task SpecificTask(int index)
  {
    return tasklist.get(index);
  }
}
