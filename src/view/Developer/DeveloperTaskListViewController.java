package view.Developer;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Region;
import model.ProjectListModel;
import model.Task;
import model.TaskList;
import view.ViewHandler;
import view.viewModels.*;

public class DeveloperTaskListViewController {

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

    timeSpent.setCellValueFactory(cellData -> cellData.getValue().getTaskTimeSpent());
    title.setCellValueFactory(cellData -> cellData.getValue().getTaskTitle());
    timeEstimeted.setCellValueFactory(cellData -> cellData.getValue().getTaskTimeEstimated());
    id.setCellValueFactory(cellData -> cellData.getValue().getTaskID());
    responsiblePerson.setCellValueFactory(cellData -> cellData.getValue().getMember());
    status.setCellValueFactory(cellData -> cellData.getValue().getTaskStatus());

    TaskList.setItems(tmodel.getList());
    TaskList.setEditable(true);
    timeSpent.setCellFactory(TextFieldTableCell.forTableColumn());

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

  public void backOnClick(ActionEvent actionEvent) {
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
    view.openView("RequirementList");
  }
  public void reset()
  {
    tmodel.update();
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

  public void editOnEdit(TableColumn.CellEditEvent<TaskViewModel, String> taskViewModelStringCellEditEvent) {
    TaskViewModel task = TaskList.getSelectionModel().getSelectedItem();
    if (task != null)
    {
      for (int x = 0; x < model.getProjects().getSize(); x++) {
        if(model.getProject(x).isOpened())
        for (int y = 0; y < model.getProject(x).getRequirements().size(); y++){
          if (model.getProject(x).getRequirement(y).isOpened())
          for (int z = 0; z < model.getProject(x).getRequirement(y).getTaskListSize(); z++){
            if(model.getProject(x).getRequirement(y).getTask(z).getTitle().equals(task.getTaskTitle().get()) && model.getProject(x).getRequirement(y).getTask(z).getTaskID().equals(task.getTaskID().get())){
              task.setTaskTimeSpent(new SimpleStringProperty(taskViewModelStringCellEditEvent.getNewValue()));
              if(Integer.parseInt(task.getTaskTimeSpent().get()) < Integer.parseInt(task.getTaskTimeEstimated().get())) {
                model.getProject(x).getRequirement(y).getTask(z).setTimeDone(Integer.parseInt(task.getTaskTimeSpent().get()));
              }
              else{
                task.setTaskTimeSpent(task.getTaskTimeEstimated());
                model.getProject(x).getRequirement(y).getTask(z).setTimeDone(Integer.parseInt(task.getTaskTimeEstimated().get()));
              }
            }
          }
      }
    }
    }
    smodel.update();
  }
}
