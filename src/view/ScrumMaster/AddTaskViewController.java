package view.ScrumMaster;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ProjectListModel;
import model.Task;
import model.Time;
import view.ViewHandler;
import view.viewModels.TaskListViewModel;

public class AddTaskViewController {

  public TextField title;
  public TextField timer;
  private Region root;
  private ViewHandler view;
  private ProjectListModel model;
  private TaskListViewModel smodel;

  public void init(Region root, ViewHandler view,ProjectListModel model){
    this.root = root;
    this.view = view;
    this.model = model;
    this.smodel = new TaskListViewModel(model);
  }
  public Region getRoot(){
    return root;
  }

  public void backOnClick(ActionEvent actionEvent) {
    view.openView("TaskList");
  }

  public void createOnClick(ActionEvent actionEvent) {
    for (int i = 0; i < model.getProjects().getSize(); i++)
    {
      if (model.getProject(i).isOpened())
      {
        for(int p = 0; p < model.getProject(i).getRequirements().size();p++)
        {
         if(model.getProject(i).getRequirement(p).isOpened())
         {
           int lo = Integer.parseInt(timer.getText());
           model.getProject(i).getRequirement(p).addTask(new Task(title.getText(),lo));
           model.getProject(i).getRequirement(p).setDisapproved(false);
         }
        }
      }
    }
    view.openView("TaskList");
  }
  public void reset()
  {
    smodel.update();
  }

}
