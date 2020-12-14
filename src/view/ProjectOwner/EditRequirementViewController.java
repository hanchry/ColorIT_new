package view.ProjectOwner;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.MyDate;
import model.Project;
import model.ProjectListModel;
import model.StartDate_DeadLine;
import view.ViewHandler;

public class EditRequirementViewController {

  public TextField title;
  public TextField what;
  public TextField who;
  public TextField why;
  public TextField estimatedTime;
  public DatePicker deadline;
  public TextField status;

  private Region root;
  private ViewHandler view;
  private ProjectListModel model;

  public void init(Region root, ViewHandler view, ProjectListModel model){
    this.root = root;
    this.view = view;
    this.model = model;
  }
  public Region getRoot(){
    return root;
  }

  public void backOnClick(ActionEvent actionEvent) {
    view.openView("RequirementsList");
  }


  public void editOnClick(ActionEvent actionEvent) {
    for (int x = 0; x < model.getProjects().getSize(); x++){
      if (model.getProject(x).isOpened()){
        for(int y = 0; y < model.getProject(x).getRequirements().size(); y++){
          if (model.getProject(x).getRequirement(y).isOpened()){
            model.getProject(x).getRequirement(y).setOpened(false);
            model.getProject(x).getRequirement(y).setTitle(title.getText());
            model.getProject(x).getRequirement(y).setWhat(what.getText());
            model.getProject(x).getRequirement(y).setWho(who.getText());
            model.getProject(x).getRequirement(y).setWhy(why.getText());
            MyDate deadlinee = new MyDate();
            deadlinee.set(deadline.getValue().getDayOfMonth(), deadline.getValue().getMonth().getValue(), deadline.getValue().getYear());
            StartDate_DeadLine date = new StartDate_DeadLine(deadlinee);
            model.getProject(x).getRequirement(y).setDate(date);
            model.getProject(x).getRequirement(y).setNeededtime(Integer.parseInt(estimatedTime.getText()));
          }
        }
      }
    }
    view.openView("RequirementsList");
  }
}
