package view.ScrumMaster;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.ProjectListModel;
import model.Task;
import model.Time;
import view.ViewHandler;

public class AddTaskViewController {

  public TextField title;
  public TextField timer;
  private Region root;
  private ViewHandler view;
  private ProjectListModel model;

  public void init(Region root, ViewHandler view,ProjectListModel model){
    this.root = root;
    this.view = view;
    this.model = model;
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
         if( model.getProject(i).getRequirement(p).isOpened())
         {
           model.getProject(i).getRequirement(p).addTask(new Task("id",title.getText(),Integer.parseInt(timer.getText())));
         }
        }
      }
    }
    view.openView("TaskList");
    System.out.println(model.getProject(0).getRequirement(0).getTaskListSize());
    System.out.println(model.getProject(1).getRequirement(0).getTaskListSize());
  }
  public void reset()
  {

  }
}
