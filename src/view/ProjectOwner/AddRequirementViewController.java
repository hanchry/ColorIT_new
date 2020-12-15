package view.ProjectOwner;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;
import view.ViewHandler;
import model.Time;
import model.StartDate_DeadLine;

import javax.xml.stream.events.StartDocument;

public class AddRequirementViewController
{

  public TextField title;
  public TextField what;
  public TextField who;
  public TextField why;
  public DatePicker deadline;

  private Region root;
  private ViewHandler view;
  private ProjectListModel model;

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
    view.openView("RequirementsList");
  }

  public void createOnClick(ActionEvent actionEvent)
  {
    for (int i = 0; i < model.getProjects().getSize(); i++)
    {
      if (model.isProjectOpened(i))
      {
        MyDate date2 = new MyDate(deadline.getValue().getDayOfMonth(),
            deadline.getValue().getMonthValue(), deadline.getValue().getYear());
        StartDate_DeadLine startDate_deadLine = new StartDate_DeadLine(date2);
        model.getProject(i).addRequriement(
            new Requirement(title.getText(), why.getText(), who.getText(),
                what.getText(), startDate_deadLine));
      }
    }
    title.setText("");
    what.setText("");
    who.setText("");
    why.setText("");
    deadline.setValue(null);
    view.openView("RequirementsList");
  }

}
