package view.ProjectCreator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;
import view.ViewHandler;
import view.viewModels.TeamMembersListViewModel;

public class RoleViewController {

  @FXML private TextField role;
  private ProjectListModel model;
  private TeamMembersListViewModel smodel;

  public Label nameOfPerson;
  private Region root;
  private ViewHandler view;

  public void init(Region root, ViewHandler view, ProjectListModel model){
    this.root = root;
    this.view = view;
    this.model = model;
  }
  public Region getRoot(){
    return root;
  }


  public void backOnClick(ActionEvent actionEvent) {
    view.openView("TeamMemberList");
  }


  public void scrumOnClick(ActionEvent actionEvent) {
    for (int i = 0; i < model.devSize(); i++) {
      if (model.getDeveloper(i).isOpened()) {
        model.getDeveloper(i).setOpened(false);
        model.addScrum(new ScrumMaster(model.getDeveloper(i).getName(),model.getDeveloper(i).getEmail(),"ScrumMaster"));
        model.removeDeveloper(i);
      }
    }
    for (int i = 0; i < model.getOwners().size(); i++) {
      if (model.getOwner(i).isOpened()) {
        model.getOwner(i).setOpened(false);
        model.addScrum(new ScrumMaster(model.getOwner(i).getName(),model.getOwner(i).getEmail(),"ScrumMaster"));
        model.removeOwner(i);
      }
    }
    for (int i = 0; i < model.getScrums().size(); i++) {
      if (model.getScrum(i).isOpened()) {
        model.getScrum(i).setOpened(false);
        model.getScrum(i).setRole("ScrumMaster");
      }
    }
    if(model.getCreator() != null && model.getCreator().isOpened()) {
      model.getCreator().setOpened(false);
      model.addScrum(new ScrumMaster(model.getCreator().getName(),model.getCreator().getEmail(),"ScrumMaster"));
      model.setCreator(null);
    }
    view.openView("TeamMemberList");
  }


  public void projectCreatorOnClick(ActionEvent actionEvent) {
    for (int i = 0; i < model.devSize(); i++) {
      if (model.getDeveloper(i).isOpened()) {
        model.getDeveloper(i).setOpened(false);
        model.setCreator(new ProjectCreator(model.getDeveloper(i).getName(),model.getDeveloper(i).getEmail(),"ProjectCreator"));
        model.removeDeveloper(i);
      }
    }
    for (int i = 0; i < model.getOwners().size(); i++) {
      if (model.getOwner(i).isOpened()) {
        model.getOwner(i).setOpened(false);
        model.setCreator(new ProjectCreator(model.getOwner(i).getName(),model.getOwner(i).getEmail(),"ProjectCreator"));
        model.removeOwner(i);
      }
    }
    for (int i = 0; i < model.getScrums().size(); i++) {
      if (model.getScrum(i).isOpened()) {
        model.getScrum(i).setOpened(false);
        model.setCreator(new ProjectCreator(model.getScrum(i).getName(),model.getScrum(i).getEmail(),"ProjectCreator"));
        model.removeScrum(i);
      }
    }
    if(model.getCreator() != null && model.getCreator().isOpened()) {
      model.getCreator().setOpened(false);
      model.getCreator().setRole("ProjectCreator");
    }
    view.openView("TeamMemberList");
  }

  public void projectOwnerOnClick(ActionEvent actionEvent) {
    for (int i = 0; i < model.devSize(); i++) {
      if (model.getDeveloper(i).isOpened()) {
        model.getDeveloper(i).setOpened(false);
        model.addOwner(new ProjectOwner(model.getDeveloper(i).getName(),model.getDeveloper(i).getEmail(),"ProjectOwner"));
        model.removeDeveloper(i);
      }
    }
    for (int i = 0; i < model.getOwners().size(); i++) {
      if (model.getOwner(i).isOpened()) {
        model.getOwner(i).setOpened(false);
        model.getOwner(i).setRole("ProjectOwner");
      }
    }
    for (int i = 0; i < model.getScrums().size(); i++) {
      if (model.getScrum(i).isOpened()) {
        model.getScrum(i).setOpened(false);
        model.addOwner(new ProjectOwner(model.getScrum(i).getName(),model.getScrum(i).getEmail(),"ProjectOwner"));
        model.removeScrum(i);
      }
    }
    if(model.getCreator() != null && model.getCreator().isOpened()) {
      model.getCreator().setOpened(false);
      model.addOwner(new ProjectOwner(model.getCreator().getName(),model.getCreator().getEmail(),"ProjectOwner"));
      model.setCreator(null);
    }
    view.openView("TeamMemberList");
  }

  public void developerOnClick(ActionEvent actionEvent) {
    for (int i = 0; i < model.devSize(); i++) {
      if (model.getDeveloper(i).isOpened()) {
        model.getDeveloper(i).setOpened(false);
        model.getDeveloper(i).setRole("Developer");
      }
    }
    for (int i = 0; i < model.getOwners().size(); i++) {
      if (model.getOwner(i).isOpened()) {
        model.getOwner(i).setOpened(false);
        model.addPerson(new Developer(model.getOwner(i).getName(),model.getOwner(i).getEmail(),"Developer"));
        model.removeOwner(i);
      }
    }
    for (int i = 0; i < model.getScrums().size(); i++) {
      if (model.getScrum(i).isOpened()) {
        model.getScrum(i).setOpened(false);
        model.addPerson(new Developer(model.getScrum(i).getName(),model.getScrum(i).getEmail(),"Developer"));
        model.removeScrum(i);
      }
    }
    if(model.getCreator() != null && model.getCreator().isOpened()) {
      model.getCreator().setOpened(false);
      model.addPerson(new Developer(model.getCreator().getName(),model.getCreator().getEmail(),"Developer"));
      model.setCreator(null);
    }
    view.openView("TeamMemberList");
  }
}
