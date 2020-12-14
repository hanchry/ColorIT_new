package view.ProjectCreator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.MyDate;
import model.ProjectListModel;
import model.StartDate_DeadLine;
import view.ViewHandler;
import view.viewModels.ProjectViewModel;
import view.viewModels.TeamMembersListViewModel;
import view.viewModels.TeamMembersViewModel;

public class TeamMemberListViewController {

  public TableView<TeamMembersViewModel> table;
  @FXML private TableColumn<TeamMembersViewModel, String> name;
  @FXML private TableColumn<TeamMembersViewModel, String> email;
  @FXML private TableColumn<TeamMembersViewModel, String> role;

  private TeamMembersListViewModel smodel;
  private ProjectListModel model;

  private Region root;
  private ViewHandler view;

  public void init(Region root, ViewHandler view, ProjectListModel model){
    this.root = root;
    this.view = view;
    this.model = model;
    this.smodel = new TeamMembersListViewModel(model);

    name.setCellValueFactory(cellData -> cellData.getValue().getName());
    email.setCellValueFactory(cellData -> cellData.getValue().getEmail());
    role.setCellValueFactory(cellData -> cellData.getValue().getRole());


    table.setItems(smodel.getList());
  }
  public Region getRoot(){
    return root;
  }


  public void backOnClick(ActionEvent actionEvent) {
    view.openView("ProjectListCreate");
  }

  public void addOnClick(ActionEvent actionEvent) {
    view.openView("AddMember");
  }

  public void removeOnClick(ActionEvent actionEvent) {
    TeamMembersViewModel selected = table.getSelectionModel().getSelectedItem();
    if (selected.getRole().get().equals("Developer")) {
      for (int x = 0; x < model.devSize(); x++) {
        if (model.getDeveloper(x).getName().equals(selected.getName().get()) && model.getDeveloper(x).getEmail()
            .equals(selected.getEmail().get())) {
          model.removeDeveloper(x);
        }
      }
    }
    if (selected.getRole().get().equals("ScrumMaster")){
      for (int x = 0; x < model.getScrums().size(); x++) {
        if (model.getScrum(x).getName().equals(selected.getName().get()) && model.getScrum(x).getEmail()
            .equals(selected.getEmail().get())) {
          model.removeScrum(x);
        }
      }
    }
    if (selected.getRole().get().equals("ProjectCreator")){
      model.setCreator(null);
    }
    if (selected.getRole().get().equals("ProjectOwner")){
      for (int x = 0; x < model.getOwners().size(); x++) {
        if (model.getOwner(x).getName().equals(selected.getName().get()) && model.getOwner(x).getEmail()
            .equals(selected.getEmail().get())) {
          model.removeScrum(x);
        }
      }
    }
    smodel.update();
  }

  public void changeOnClick(ActionEvent actionEvent) {

    TeamMembersViewModel selectedMember = table.getSelectionModel().getSelectedItem();
    if (selectedMember != null)
    {
      for (int x = 0; x < model.getDevelopers().size(); x++)
      {
        if (model.getDeveloper(x).getName().equals(selectedMember.getName().get()))
        {
          model.getDeveloper(x).setOpened(true);
        }
      }
      for (int x = 0; x < model.getScrums().size(); x++)
      {
        if (model.getScrum(x).getName().equals(selectedMember.getName().get()))
        {
          model.getScrum(x).setOpened(true);
        }
      }
      for (int x = 0; x < model.getOwners().size(); x++)
      {
        if (model.getOwner(x).getName().equals(selectedMember.getName().get()))
        {
          model.getOwner(x).setOpened(true);
        }
      }
      if (model.getCreator() != null && model.getCreator().getName().equals(selectedMember.getName().get())){
        model.getCreator().setOpened(true);
      }

      view.openView("Role");
    }
  }



  public void reset()
  {
    smodel.update();
  }
}

