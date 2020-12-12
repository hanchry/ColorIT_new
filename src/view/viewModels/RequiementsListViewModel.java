package view.viewModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ProjectListModel;
import model.Requirement;

public class RequiementsListViewModel {
  private ObservableList<RequiementsViewModel> list;
  private ProjectListModel model;

  public RequiementsListViewModel(ProjectListModel model){
    this.model = model;
    this.list = FXCollections.observableArrayList();
    update();
  }

  public void update()
  {
    list.clear();
    for (int x = 0; x < model.projectListSize(); x++){
      if (model.isProjectOpened(x)){
        for (int i = 0; i < model.getProject(x).getRequirements().size(); i++)
        {
          list.add(new RequiementsViewModel(model.getProject(x).getRequirement(i)));
        }
      }
    }
  }

  public ObservableList<RequiementsViewModel> getList()
  {
    return list;
  }


  public void add(Requirement requirement)
  {for (int x = 0; x < model.projectListSize(); x++){
    if (model.isProjectOpened(x)){
      list.add(new RequiementsViewModel(model.getProject(x).getRequirement(model.getProject(x).getRequirements().size()-1)));
    }
    }
  }

}