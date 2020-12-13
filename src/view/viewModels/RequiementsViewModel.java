package view.viewModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import model.Requirement;

public class RequiementsViewModel {
  private StringProperty why;
  private StringProperty who;
  private StringProperty what;
  private StringProperty ID;
  private StringProperty neededTime;
  private StringProperty DeadLine;
  private StringProperty responsibleDeveloper;

  public RequiementsViewModel(Requirement requirement){

    who = new SimpleStringProperty(requirement.getWho());
    why = new SimpleStringProperty(requirement.getWhy());
    ID = new SimpleStringProperty(requirement.getID());
    what = new SimpleStringProperty(requirement.getWhat());

  }

  public StringProperty getWho() {
    return who;
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

  public StringProperty neededTimeProperty()
  {
    return neededTime;
  }
  public StringProperty responsibleDeveloperProperty()
  {
    return responsibleDeveloper;
  }

  public ObservableList<ProjectViewModel> getList()
  {
    return getList();
  }

}
