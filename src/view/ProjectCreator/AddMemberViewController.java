package view.ProjectCreator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import model.Developer;
import model.Person;
import model.ProjectListModel;
import view.ViewHandler;
import view.viewModels.TeamMembersListViewModel;
import javafx.scene.control.TextField;

import java.awt.*;

public class AddMemberViewController {

  @FXML private TextField name;
  @FXML private TextField email;
  private ProjectListModel model;
  private TeamMembersListViewModel smodel;

  private Region root;
  private ViewHandler view;

  public void init(Region root, ViewHandler view, ProjectListModel model){
    this.root = root;
    this.view = view;
    this.model = model;
    this.smodel = new TeamMembersListViewModel(model);
  }
  public Region getRoot(){
    return root;
  }

  public void backOnClick(ActionEvent actionEvent) {
    view.openView("TeamMemberList");
  }

  public void addOnClick(ActionEvent actionEvent) {
    Person person = new Developer(name.getText(), email.getText(), "Developer");
    model.addPerson(person);
    view.openView("TeamMemberList");
    name.setText("");
    email.setText("");
  }

  public void reset(){
    smodel.update();
  }

}
