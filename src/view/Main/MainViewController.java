package view.Main;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import view.ViewHandler;

public class MainViewController {

  private Region root;
  private ViewHandler view;

  public void init(Region root, ViewHandler view){
    this.root = root;
    this.view = view;
  }
  public Region getRoot(){
    return root;
  }

  public void ProjectCreatorOnClick(ActionEvent actionEvent) {
    view.openView("ProjectListCreate");
  }

  public void ScrumMasterOnClick(ActionEvent actionEvent) {
    view.openView("ScrumProjectListRequirements");
  }

  public void ProjectOwnerOnCLick(ActionEvent actionEvent) {
    view.openView("ProjectListRequirements");
  }

  public void DeveloperOnCLick(ActionEvent actionEvent) {
    view.openView("ProjectList");
  }

  public void teamMembersOnClick(ActionEvent actionEvent) {
    view.openView("TeamMembers");
  }
}
