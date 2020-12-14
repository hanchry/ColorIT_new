package view.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.ProjectListModel;
import view.ViewHandler;
import view.viewModels.TeamMembersListViewModel;
import view.viewModels.TeamMembersViewModel;

public class TeamMembersViewController {

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
    smodel.update();
  }
  public Region getRoot(){
    return root;
  }


  public void backOnCLick(ActionEvent actionEvent) {
    view.openView("Main");
  }

  public void reset(){
    smodel.update();
  }
}
