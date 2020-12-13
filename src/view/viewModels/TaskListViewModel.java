package view.viewModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ProjectListModel;
import model.Task;

public class TaskListViewModel
{
  private ObservableList<TaskViewModel> list;
  private ProjectListModel model;

  public TaskListViewModel(ProjectListModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  public void update()
  {
    list.clear();
    for (int x = 0; x < model.projectListSize(); x++)
    {
      if (model.getProject(x).isOpened())
      {
        for (int z = 0; z < model.getProject(x).getRequirements().size(); z++)
        {
          if (model.getProject(x).getRequirement(z).isOpened())
          {
            for (int y = 0; y < model.getProject(x).getRequirement(z)
                .getTaskListSize(); y++)
            {
              list.add(new TaskViewModel(
                  model.getProject(x).getRequirement(z).getTask(y)));
            }
          }
        }
      }
    }
  }


  public ObservableList<TaskViewModel> getList()
  {
    return list;
  }

  public void remove(Task task)
  {

  }

  public void add(Task task)
  {
    for (int x = 0; x < model.projectListSize(); x++)
    {
      if (model.isProjectOpened(x))
      {
        for (int b = 0; b < model.getProject(x).getRequirements().size(); b++)
          if (model.getProject(x).getRequirement(b).isOpened())
          {
            list.add(new TaskViewModel(model.getProject(x).getRequirement(b)
                .getTask(model.getProject(x).getRequirement(b).getTaskListSize()
                    - 1)));

          }

      }
    }
  }
}
