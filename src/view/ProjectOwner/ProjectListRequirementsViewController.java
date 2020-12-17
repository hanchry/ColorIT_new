package view.ProjectOwner;

import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.ProjectListModel;
import parser.ParserException;
import parser.XmlJsonParser;
import view.ViewHandler;
import view.viewModels.ProjectListViewModel;
import view.viewModels.ProjectViewModel;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ProjectListRequirementsViewController
{

  public TableView<ProjectViewModel> ProjectList;
  public TableColumn<ProjectViewModel, String> title;
  public TableColumn<ProjectViewModel, String> startDate;
  public TableColumn<ProjectViewModel, String> deadline;
  public TableColumn<ProjectViewModel, String> timeSpendet;
  public TableColumn<ProjectViewModel, String> timeEstimeted;
  public TableColumn<ProjectViewModel, String> requirementsDone;
  public TableColumn<ProjectViewModel, String> status;

  private Region root;
  private ViewHandler view;
  private ProjectListModel model;
  private ProjectListViewModel smodel;

  public void init(Region root, ViewHandler view, ProjectListModel model)
  {
    this.root = root;
    this.view = view;
    this.model = model;
    this.smodel = new ProjectListViewModel(model);

    title
        .setCellValueFactory(cellData -> cellData.getValue().getProjectTitle());
    startDate.setCellValueFactory(
        cellData -> cellData.getValue().getProjectStartDate());
    deadline.setCellValueFactory(
        cellData -> cellData.getValue().getProjectDeadline());
    timeEstimeted.setCellValueFactory(
        cellData -> cellData.getValue().getProjectTimeEstimeted());
    timeSpendet.setCellValueFactory(
        cellData -> cellData.getValue().getProjectTimeSpent());
    requirementsDone.setCellValueFactory(cellData -> cellData.getValue().getProjectRequirementsDone());
    status.setCellValueFactory(
        cellData -> cellData.getValue().getProjectStatus());

    ProjectList.setItems(smodel.getList());

  }

  public Region getRoot()
  {
    return root;
  }

  public void backOnClick(ActionEvent actionEvent)
  {
    view.openView("Main");
  }

  public void showOnClick(ActionEvent actionEvent)
  {
    ProjectViewModel selectedProject = ProjectList.getSelectionModel()
        .getSelectedItem();
    if (selectedProject != null)
    {
      for (int x = 0; x < model.getProjects().getSize(); x++)
      {
        if (model.getProject(x).getTitle()
            .equals(selectedProject.getProjectTitle().get()))
        {
          model.getProject(x).setOpened(true);
        }
      }
      view.openView("RequirementsList");
    }
  }

  public void reset()
  {
    smodel.update();
  }

  public void webPageOnAction(ActionEvent actionEvent)
      throws ParserException, URISyntaxException, IOException
  {
    XmlJsonParser parser = new XmlJsonParser();
    File file = parser.toJson(this.model.getProjects(), "../projecwork.json");
    System.out.println("File: " + file.getAbsolutePath());
    Desktop d = Desktop.getDesktop();
    d.browse(new URI("https://davidmichalco.000webhostapp.com/project.html"));


  }
}
