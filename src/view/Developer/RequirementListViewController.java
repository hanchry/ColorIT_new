package view.Developer;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.ProjectListModel;
import view.ViewHandler;
import view.viewModels.ProjectListViewModel;
import view.viewModels.ProjectViewModel;
import view.viewModels.RequiementsListViewModel;
import view.viewModels.RequiementsViewModel;

public class RequirementListViewController {

  public TableView<RequiementsViewModel> RequirementsList;
  public TableColumn<RequiementsViewModel,String> id;
  public TableColumn<RequiementsViewModel,String>  title;
  public TableColumn<RequiementsViewModel,String>  what;
  public TableColumn<RequiementsViewModel,String>  who;
  public TableColumn<RequiementsViewModel,String>  why;
  public TableColumn<RequiementsViewModel,String>  startedDate;
  public TableColumn<RequiementsViewModel,String>  deadline;
  public TableColumn<RequiementsViewModel,String>  spendetTime;
  public TableColumn<RequiementsViewModel,String>  estimatedTime;
  public TableColumn<RequiementsViewModel,String>  responsiblePerson;
  public TableColumn<RequiementsViewModel,String>  status;
  public Label titleLabel;
  private Region root;
  private ViewHandler view;
  private ProjectListModel model;
  private RequiementsListViewModel smodel;
  private ProjectListViewModel pmodel;

  public void init(Region root, ViewHandler view, ProjectListModel model)
  {
    this.root = root;
    this.view = view;
    this.smodel = new RequiementsListViewModel(model);
    this.pmodel = new ProjectListViewModel(model);
    this.model = model;

    spendetTime.setCellValueFactory(cellData -> cellData.getValue().getTimeSpent());
    who.setCellValueFactory(cellData -> cellData.getValue().getWho());
    what.setCellValueFactory(cellData -> cellData.getValue().getWhat());
    why.setCellValueFactory(cellData -> cellData.getValue().getWhy());
    id.setCellValueFactory(cellData -> cellData.getValue().getID());
    startedDate.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
    deadline.setCellValueFactory(cellData -> cellData.getValue().deadLineProperty());
    estimatedTime.setCellValueFactory(cellData -> cellData.getValue().neededTimeProperty());
    id.setCellValueFactory(cellData -> cellData.getValue().getID());
    responsiblePerson.setCellValueFactory(cellData -> cellData.getValue().responsibleDeveloperProperty());
    status.setCellValueFactory(cellData ->cellData.getValue().getStatus());
    title.setCellValueFactory(cellData ->cellData.getValue().getTitle());


    RequirementsList.setItems(smodel.getList());
    for (int x = 0; x < model.getProjects().getSize(); x++){
      if (model.getProject(x).isOpened()){
        titleLabel.setText(model.getProject(x).getTitle());
      }
    }
  }

  public Region getRoot()
  {
    return root;
  }

  public void backOnClick(ActionEvent actionEvent) {
    for (int x = 0; x < model.getProjects().getSize(); x++)
    {
      if (model.getProject(x).isOpened())
      {
        model.getProject(x).setOpened(false);
      }
    }
    view.openView("ProjectList");
  }

  public void showOnClick(ActionEvent actionEvent)
  {
    RequiementsViewModel selectedRequirement = RequirementsList.getSelectionModel()
        .getSelectedItem();
    if (selectedRequirement != null)
    {
      for (int x = 0; x < model.getProjects().getSize(); x++)
      {
        if (model.getProject(x).isOpened())
        {
          for (int o = 0; o < model.getProject(x).getRequirements().size();o++)
          {
            if (model.getProject(x).getRequirement(o).getWhat().equals(selectedRequirement.getWhat().get()))
            {
              model.getProject(x).getRequirement(o).setOpened(true);
            }
          }
        }
      }
      view.openView("DeveloperTaskList");
    }
  }

  public void reset()
  {
    for (int x = 0; x < model.getProjects().getSize(); x++){
      if (model.getProject(x).isOpened()){
        titleLabel.setText(model.getProject(x).getTitle());
      }
    }
    smodel.update();
  }
}

