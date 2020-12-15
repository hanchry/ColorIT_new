package view.ScrumMaster;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import model.Developer;
import model.ProjectListModel;
import view.ViewHandler;
import view.viewModels.*;

public class TaskListViewController
{

  public TableView<TaskViewModel> TaskList;
  public TableColumn<TaskViewModel, String> id;
  public TableColumn<TaskViewModel, String> title;
  public TableColumn<TaskViewModel, String> timeSpent;
  public TableColumn<TaskViewModel, String> timeEstimeted;
  public TableColumn<TaskViewModel, String> responsiblePerson;
  public TableColumn<TaskViewModel, String> status;
  public Label titleLabel;
  private Region root;
  private ViewHandler view;
  private ProjectListModel model;
  private RequiementsListViewModel smodel;
  private ProjectListViewModel pmodel;
  private TaskListViewModel tmodel;

  public void init(Region root, ViewHandler view, ProjectListModel model)
  {
    this.root = root;
    this.view = view;
    this.smodel = new RequiementsListViewModel(model);
    this.pmodel = new ProjectListViewModel(model);
    this.model = model;
    this.tmodel = new TaskListViewModel(model);

    title.setCellValueFactory(cellData -> cellData.getValue().getTaskTitle());
    timeEstimeted.setCellValueFactory(
        cellData -> cellData.getValue().getTaskTimeEstimated());
    responsiblePerson.setCellValueFactory(cellData -> cellData.getValue().getMember());
    TaskList.setItems(tmodel.getList());

    for (int x = 0; x < model.getProjects().getSize(); x++){
      if (model.getProject(x).isOpened()){
        for (int y = 0; y < model.getProject(x).getRequirements().size(); y++){
          if ( model.getProject(x).getRequirement(y).isOpened()){
            titleLabel.setText(model.getProject(x).getRequirement(y).getTitle());
          }
        }
      }
    }
  }

  public Region getRoot()
  {
    return root;
  }

  public void backOnClick(ActionEvent actionEvent)
  {
    for (int i = 0; i < model.getProjects().getSize(); i++)
    {
      if (model.getProject(i).isOpened())
      {
        for (int p = 0; p < model.getProject(i).getRequirements().size(); p++)
        {
          if (model.getProject(i).getRequirement(p).isOpened())
          {
            model.getProject(i).getRequirement(p).setOpened(false);
          }
        }
      }
    }
    view.openView("RequirementsListTasks");
  }

  public void addOnClick(ActionEvent actionEvent)
  {
    view.openView("AddTask");
  }

  public void deleteOnClick(ActionEvent actionEvent)
  {
  }

  public void assignePersonOnClick(ActionEvent actionEvent)
  {
    TaskViewModel selectedItem = TaskList.getSelectionModel().getSelectedItem();

    if(selectedItem != null) {
      for (int x = 0; x < model.getProjects().getSize(); x++) {
        if (model.getProject(x).isOpened()) {
          for (int o = 0; o < model.getProject(x).getRequirements().size(); o++) {
            if (model.getProject(x).getRequirement(o).isOpened()) {
              for (int e = 0; e < model.getProject(x).getRequirement(o)
                  .getTaskListSize(); e++) {
                if (model.getProject(x).getRequirement(o).getTask(e).getTitle().equals(selectedItem.getTaskTitle().get())) {
                  model.getProject(x).getRequirement(o).getTask(e).setIsOpened(true);
                }
              }
            }
          }
        }
      }
      view.openView("AssignePersonTask");
    }
  }

  public void reset()
  {
    for (int x = 0; x < model.getProjects().getSize(); x++){
      if (model.getProject(x).isOpened()){
        for (int y = 0; y < model.getProject(x).getRequirements().size(); y++){
          if ( model.getProject(x).getRequirement(y).isOpened()){
            titleLabel.setText(model.getProject(x).getRequirement(y).getTitle());
          }
        }
      }
    }
    tmodel.update();
  }
}
