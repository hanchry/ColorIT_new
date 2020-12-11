package view.viewModels;

import javafx.beans.property.SimpleStringProperty;
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
   projectTimeSpent = new SimpleStringProperty(project.getHoursSpent());
   projectTimeEstimeted = new SimpleStringProperty(project.getHoursEstimated());
   projectStatus = new SimpleStringProperty(project.getStatus());
 }

  public String getProjectDeadline() {
    return projectDeadline.get();
  }

  public String getProjectStartDate() {
    return projectStartDate.get();
  }

  public String getProjectStatus() {
    return projectStatus.get();
  }

  public String getProjectTimeEstimeted() {
    return projectTimeEstimeted.get();
  }

  public String getProjectTimeSpent() {
    return projectTimeSpent.get();
  }

  public String getProjectTitle() {
    return projectTitle.get();
  }
}
