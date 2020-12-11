package view.Developer;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import view.ViewHandler;

public class RequirementListViewController {

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
    view.openView("ProjectList");
  }

  public void showOnClick(ActionEvent actionEvent) {
    view.openView("DeveloperTaskList");
  }
}
