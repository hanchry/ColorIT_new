package view.viewModels;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Person;
import model.Task;

public class TeamMembersViewModel {

  private StringProperty name;
  private StringProperty email;
  private StringProperty role;

  public TeamMembersViewModel(Person person){
    name = new SimpleStringProperty(person.getName());
    email = new SimpleStringProperty(person.getEmail());
    role = new SimpleStringProperty(person.getRole());
  }

  public StringProperty getName() {
    return name;
  }

  public StringProperty getEmail() {
    return email;
  }

  public StringProperty getRole() {
    return role;
  }

}