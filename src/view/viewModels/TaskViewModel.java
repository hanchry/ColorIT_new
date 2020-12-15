package view.viewModels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Task;

public class TaskViewModel
{
  private StringProperty taskID;
  private StringProperty taskTitle;
  private StringProperty member;
  private StringProperty taskTimeSpent;
  private StringProperty taskTimeEstimated;

  public TaskViewModel(Task task){
    taskID = new SimpleStringProperty(task.getTaskID());
    taskTimeEstimated = new SimpleStringProperty(task.getEstimatedTime());
    taskTitle = new SimpleStringProperty(task.getTitle());

    if(task.getResponsibleDeveloper() == null){
      member = new SimpleStringProperty("none");
    }
    else {
      member = new SimpleStringProperty(task.getResponsibleDeveloper().getName());
    }
  }

  public StringProperty getTaskID() {
    return taskID;
  }

  public StringProperty getTaskTitle() {
    return taskTitle;
  }

  public StringProperty getTaskTimeEstimated() {
    return taskTimeEstimated;
  }

  public StringProperty getTaskTimeSpent() {
    return taskTimeSpent;
  }

  public StringProperty getMember() {
    return member;
  }
}
