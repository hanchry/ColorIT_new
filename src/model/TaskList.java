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

  public Task getTask(int index)
  {
    return tasklist.get(index);
  }

  public Task specificTask(Task task)
  {
    for (int i=0; i < tasklist.size(); i++)
    {
      if (tasklist.get(i).getTaskID() == task.getTaskID())
      {
        return tasklist.get(i);
      }
    }
    return null;
  }

}
