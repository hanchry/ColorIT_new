package view.ProjectCreator;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;
import view.ViewHandler;
import view.viewModels.ProjectListViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CreateProjectViewController
{
  public DatePicker deadline;
  public TextField title;
  public TextField estimetedTime;
  private ProjectListModel model;
  private Region root;
  private ViewHandler view;
  private ProjectListViewModel pmodel;

  public void init(Region root, ViewHandler view, ProjectListModel model)
  {
    this.root = root;
    this.view = view;
    this.pmodel = new ProjectListViewModel(model);
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

  public void createOnClick(ActionEvent actionEvent)
  {

    MyDate date2 = new MyDate(deadline.getValue().getDayOfMonth(), deadline.getValue().getMonthValue(), deadline.getValue().getYear());
    StartDate_DeadLine startDate_deadLine = new StartDate_DeadLine(date2);
    Time time = new Time(Double.parseDouble(estimetedTime.getText()));
    Project pt = new Project(title.getText(),startDate_deadLine, time);
    pt.setOpened(false);
    model.addProject(pt);
    title.setText("");
    estimetedTime.setText("");
    view.openView("ProjectListCreate");
    deadline.setValue(null);

  }
  public void reset()
  {
    pmodel.update();
  }
}
