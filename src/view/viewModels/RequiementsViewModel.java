package view.viewModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import model.Requirement;
import model.StartDate_DeadLine;

public class RequiementsViewModel {
  private StringProperty title;
  private StringProperty why;
  private StringProperty who;
  private StringProperty what;
  private StringProperty ID;
  private StringProperty neededTime;
  private StringProperty DeadLine;
  private StringProperty StartDate;
  private StringProperty responsibleDeveloper;

  public RequiementsViewModel(Requirement requirement){

    title = new SimpleStringProperty(requirement.getTitle());
    who = new SimpleStringProperty(requirement.getWho());
    StartDate = new SimpleStringProperty(requirement.getStartDate());
    why = new SimpleStringProperty(requirement.getWhy());
    ID = new SimpleStringProperty(requirement.getID());
    what = new SimpleStringProperty(requirement.getWhat());
    neededTime = new SimpleStringProperty(requirement.getNeededtime());
    DeadLine = new SimpleStringProperty(requirement.getDeadLine());

  }

  public StringProperty getWho() {
    return who;
  }
  public StringProperty getTitle(){
    return title;
  }
  public StringProperty getID()
  {
    return ID;
  }
  public StringProperty getWhat()
  {
    return what;
  }
  public StringProperty getWhy()
  {
    return why;
  }
  public StringProperty responsibleDeveloperProperty()
  {
    return responsibleDeveloper;
  }

  public StringProperty startDateProperty()
  {
    return StartDate;
  }

  public StringProperty neededTimeProperty()
  {
    return neededTime;
  }
  public StringProperty deadLineProperty()
  {
    return DeadLine;
  }

  public ObservableList<ProjectViewModel> getList()
  {
    return getList();
  }

}
