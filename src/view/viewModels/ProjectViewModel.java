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
   //projectTimeSpent = new SimpleStringProperty(project)
 }

}
