package view.ProjectOwner;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.ProjectList;
import model.ProjectListModel;
import model.Requirement;
import view.ViewHandler;
import view.viewModels.ProjectListViewModel;
import view.viewModels.ProjectViewModel;
import view.viewModels.RequiementsListViewModel;
import view.viewModels.RequiementsViewModel;

public class RequirementsListViewController
{
  public TableView<RequiementsViewModel>  RequirementsList;
  public TableColumn<RequiementsViewModel,String> id;
  public TableColumn<RequiementsViewModel,String>  title;
  public TableColumn<RequiementsViewModel,String>  what;
  public TableColumn<RequiementsViewModel,String>  who;
  public TableColumn<RequiementsViewModel,String>  why;
  public TableColumn<RequiementsViewModel,String>  startedDate;
  public TableColumn<RequiementsViewModel,String>  deadline;
  public TableColumn<RequiementsViewModel,String>  spendetTime;
  public TableColumn<RequiementsViewModel,String>  estimatedTime1;
  public TableColumn<RequiementsViewModel,String>  responsiblePerson;
  public TableColumn<RequiementsViewModel,String>  status;

  private Region root;
  private ViewHandler view;
  private ProjectListModel model;
  private RequiementsListViewModel smodel;
  private ProjectListViewModel pmodel;

  public void init(Region root, ViewHandler view, ProjectListModel model)
  {
    this.root = root;
    this.view = view;
    this.smodel = new RequiementsListViewModel(model);
    this.pmodel = new ProjectListViewModel(model);
    this.model = model;


    who.setCellValueFactory(cellData -> cellData.getValue().getWho());
    what.setCellValueFactory(cellData -> cellData.getValue().getWhat());
    why.setCellValueFactory(cellData -> cellData.getValue().getWhy());
    id.setCellValueFactory(cellData -> cellData.getValue().getID());
    startedDate.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
    deadline.setCellValueFactory(cellData -> cellData.getValue().deadLineProperty());
    estimatedTime1.setCellValueFactory(cellData ->cellData.getValue().neededTimeProperty());


    RequirementsList.setItems(smodel.getList());
  }

  public Region getRoot()
  {
    return root;
  }

  public void backOnClick(ActionEvent actionEvent)
  {

      for (int x = 0; x < model.getProjects().getSize(); x++)
      {
        if (model.getProject(x).isOpened())
        {
          model.getProject(x).setOpened(false);
        }
      }
      view.openView("ProjectListRequirements");
    }


  public void addOnClick(ActionEvent actionEvent)
  {
      view.openView("AddRequirement");
  }


  public void deleteOnClick(ActionEvent actionEvent)
  {
  }

  public void assignePersonOnClick(ActionEvent actionEvent)
  {
    view.openView("RequirementAssignePerson");
  }

  public void editOnClick(ActionEvent actionEvent)
  {
    view.openView("EditRequirement");
  }

  public void reset()
  {

    smodel.update();
  }
}
