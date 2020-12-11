package view.ScrumMaster;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import view.ViewHandler;

public class TaskListViewController {

  private Region root;
  private ViewHandler view;

  public void init(Region root, ViewHandler view){
    this.root = root;
    this.view = view;
  }
  public Region getRoot(){
    return root;
  }

  public void backOnClick(ActionEvent actionEvent) {
    view.openView("RequirementsListTasks");
  }

  public void addOnClick(ActionEvent actionEvent) {
    view.openView("AddTask");
  }

  public void deleteOnClick(ActionEvent actionEvent) {
  }

  public void assignePersonOnClick(ActionEvent actionEvent) {
    view.openView("AssignePersonTask");
  }
}
