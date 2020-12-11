package view.ProjectCreator;

import javafx.event.ActionEvent;
import javafx.scene.layout.Region;
import view.ViewHandler;

public class ProjectListCreateViewController {

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

  public void editProjectOnClick(ActionEvent actionEvent) {
    view.openView("EditProject");
  }

  public void createProjectOnClick(ActionEvent actionEvent) {
    view.openView("CreateProject");
  }



  public void deleteProjectOnClick(ActionEvent actionEvent) {
  }

  public void showPersonOnClick(ActionEvent actionEvent) {
    view.openView("TeamMemberList");
  }
}
