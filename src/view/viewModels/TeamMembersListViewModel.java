package view.viewModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;
import model.ProjectListModel;
import model.Task;

public class TeamMembersListViewModel {
  private ObservableList<TeamMembersViewModel> list;
  private ProjectListModel model;

  public TeamMembersListViewModel(ProjectListModel model)
  {
    this.model = model;
    this.list = FXCollections.observableArrayList();
  }

  public void update()
  {
    list.clear();
    for (int x = 0; x < model.getDevelopers().size(); x++)
    {
      list.add(new TeamMembersViewModel(model.getDeveloper(x)));
    }
    for (int x = 0; x < model.getScrums().size(); x++)
    {
      list.add(new TeamMembersViewModel(model.getScrum(x)));
    }
    for (int x = 0; x < model.getOwners().size(); x++)
    {
      list.add(new TeamMembersViewModel(model.getOwner(x)));
    }
    if(model.getCreator() != null){
      list.add(new TeamMembersViewModel(model.getCreator()));
    }
  }
  public void updateDevelopers(){
    list.clear();
    for (int x = 0; x < model.getDevelopers().size(); x++)
    {
      list.add(new TeamMembersViewModel(model.getDeveloper(x)));
    }
  }


  public ObservableList<TeamMembersViewModel> getList()
  {
    return list;
  }

  public void remove(Person person)
  {
    for (int x = 0; x < list.size(); x++){
      if (list.get(x).getName().get().equals(person.getName()) && list.get(x).getEmail().get().equals(person.getEmail())){
        list.remove(x);
        break;
      }
    }
  }

  public void add(Person person) {
    list.add(new TeamMembersViewModel(person));
  }
}
