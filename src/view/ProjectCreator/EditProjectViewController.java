package view.ProjectCreator;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.MyDate;
import model.ProjectList;
import model.ProjectListModel;
import model.StartDate_DeadLine;
import view.ViewHandler;

public class EditProjectViewController
{

  public TextField title;
  public DatePicker deadline;
  private Region root;
  private ViewHandler view;
  private ProjectListModel model;
  public TextField estimetedTime;

  public void init(Region root, ViewHandler view, ProjectListModel model)
  {
    this.root = root;
    this.view = view;
    this.model = model;
  }

  public Region getRoot()
  {
    return root;
  }

  public void backOnClick(ActionEvent actionEvent)
  {
    view.openView("ProjectListCreate");
  }

  public void editOnClick(ActionEvent actionEvent)
  {

    for (int i = 0; model.getProjects().getSize() > i; i++)
      if (model.getProject(i).isOpened())
      {
        model.getProject(i).setOpened(false);
        model.getProject(i).setTitle(title.getText());
        model.getProject(i).setTimeEstimated();
        MyDate date2 = new MyDate(deadline.getValue().getDayOfMonth(),
            deadline.getValue().getMonthValue(), deadline.getValue().getYear());
        StartDate_DeadLine startDate_deadLine = new StartDate_DeadLine(date2);
        model.getProject(i).setStartDate_deadLine(startDate_deadLine);
        view.openView("ProjectListCreate");
      }
  }
}
