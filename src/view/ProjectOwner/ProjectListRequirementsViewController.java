package view.ProjectOwner;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import view.ViewHandler;

public class ProjectListRequirementsViewController {

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
    view.openView("Main");
  }

  public void showOnClick(ActionEvent actionEvent) {
    view.openView("RequirementsList");
  }
}
