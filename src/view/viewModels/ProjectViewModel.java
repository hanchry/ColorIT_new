package view.viewModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Project;

public class ProjectViewModel {
 private SimpleStringProperty projectTitle;
 private SimpleStringProperty projectStartDate;
 private SimpleStringProperty projectDeadline;
 private SimpleStringProperty projectTimeSpent;
 private SimpleStringProperty projectTimeEstimeted;
 //private SimpleStringProperty projectRequirementsDone;
 private SimpleStringProperty projectStatus;

 public ProjectViewModel(Project project){
   projectTitle = new SimpleStringProperty(project.getTitle());
projectStartDate = new SimpleStringProperty(project.getStart_deadLine().getMyDateStartDate().getDate());
projectDeadline = new SimpleStringProperty(project.getStart_deadLine().getMyDateDeadline().getDate());
   projectTimeSpent = new SimpleStringProperty(project.getTimeSpendet() + "");
   projectTimeEstimeted = new SimpleStringProperty(project.getHoursEstimated());
 //  projectStatus = new SimpleStringProperty(project.getStatus());
 }

  public StringProperty getProjectDeadline() {
    return projectDeadline;
  }

    public StringProperty getProjectStartDate() {
        return projectStartDate;
    }

    public StringProperty getProjectStatus() {
    return projectStatus;
  }

  public StringProperty getProjectTimeEstimeted() {
    return projectTimeEstimeted;
  }

  public StringProperty getProjectTimeSpent() {
    return projectTimeSpent;
  }

  public StringProperty getProjectTitle() {
    return projectTitle;
  }
}
