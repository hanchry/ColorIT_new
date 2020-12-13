package view.ScrumMaster;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
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

    TaskList.setItems(tmodel.getList());

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
    view.openView("AssignePersonTask");
  }

  public void reset()
  {
    tmodel.update();
  }
}
