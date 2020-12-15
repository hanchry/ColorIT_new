package view.ProjectOwner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.Developer;
import model.ProjectListModel;
import view.ViewHandler;
import view.viewModels.ProjectViewModel;
import view.viewModels.RequiementsViewModel;
import view.viewModels.TeamMembersListViewModel;
import view.viewModels.TeamMembersViewModel;

public class RequirementAssignePersonViewController {

  public TableView<TeamMembersViewModel> table;
  public Label nameLabel;
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
    for (int x = 0; x < model.getProjects().getSize(); x++){
      if (model.getProject(x).isOpened()){
        for (int y = 0; y < model.getProject(x).getRequirements().size(); y++){
          if (model.getProject(x).getRequirement(y).isOpened()){
            nameLabel.setText(model.getProject(x).getRequirement(y).getTitle());
          }
        }
      }
    }
    smodel.updateDevelopers();
  }
  public Region getRoot(){
    return root;
  }

  public void backOnClick(ActionEvent actionEvent) {
    for (int x = 0; x < model.getProjects().getSize(); x++)
    {
      if (model.getProject(x).isOpened())
      {
        for (int o = 0; o < model.getProject(x).getRequirements().size();o++)
        {
          if (model.getProject(x).getRequirement(o).isOpened())
          {
            model.getProject(x).getRequirement(o).setOpened(false);
            model.getProject(x).getRequirement(o).setResponsibleDeveloper(null);
          }
        }
      }
    }
    view.openView("RequirementsList");
  }

  public void assigneOnClick(ActionEvent actionEvent) {
    TeamMembersViewModel selectedItem = table.getSelectionModel().getSelectedItem();
    if (selectedItem != null)
    {
      for (int x = 0; x < model.getProjects().getSize(); x++)
      {
        if (model.getProject(x).isOpened())
        {
          for (int o = 0; o < model.getProject(x).getRequirements().size();o++)
          {
            if (model.getProject(x).getRequirement(o).isOpened())
            {
              model.getProject(x).getRequirement(o).setOpened(false);
              model.getProject(x).getRequirement(o).setResponsibleDeveloper(new Developer(selectedItem.getName().get(),selectedItem.getEmail().get(),selectedItem.getRole().get()));
            }
          }
        }
      }
      view.openView("RequirementsList");
    }
    }
  public void reset()
  {
    for (int x = 0; x < model.getProjects().getSize(); x++){
      if (model.getProject(x).isOpened()){
        for (int y = 0; y < model.getProject(x).getRequirements().size(); y++){
          if (model.getProject(x).getRequirement(y).isOpened()){
            nameLabel.setText(model.getProject(x).getRequirement(y).getTitle());
          }
        }
      }
    }
    smodel.updateDevelopers();
  }
  }

