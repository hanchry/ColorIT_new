package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.ProjectListModel;
import view.Developer.DeveloperTaskListViewController;
import view.Developer.ProjectListViewController;
import view.Developer.RequirementListViewController;
import view.Main.MainViewController;
import view.Main.TeamMembersViewController;
import view.ProjectCreator.*;
import view.ProjectOwner.*;
import view.ScrumMaster.*;

public class ViewHandler
{

  private Scene currentScene;
  private Stage primaryStage;
  private Region root;
  private ProjectListModel model;

  ///////////////////////DEVELOPER/////////////////////////////
  private ProjectListViewController projectListViewController;
  private DeveloperTaskListViewController developerTaskListViewController;
  private RequirementListViewController requirementListViewController;

  //////////////////////MAIN VIEW///////////////////////////
  private MainViewController mainViewController;
  private TeamMembersViewController teamMembersViewController;

  //////////////////////CREATOR////////////////////////////
  private AddMemberViewController addMemberViewController;
  private CreateProjectViewController createProjectViewController;
  private ProjectListCreateViewController projectListCreateViewController;
  private EditProjectViewController editProjectViewController;
  private TeamMemberListViewController teamMemberListViewController;
  private RoleViewController roleViewController;

  /////////////////////OWNER/////////////////////////////
  private AddRequirementViewController addRequirementViewController;
  private ProjectListRequirementsViewController projectListRequirementsViewController;
  private RequirementsListViewController requirementsListViewController;
  private RequirementAssignePersonViewController requirementAssignePersonViewController;
  private EditRequirementViewController editRequirementViewController;

  //////////////////////SCRUM//////////////////////////
  private AddTaskViewController addTaskViewController;
  private ScrumProjectListRequirementsViewController scrumProjectListRequirementsViewController;
  private RequirementsListTasksViewController requirementsListTasksViewController;
  private TaskListViewController taskListViewController;
  private AssignePersonTaskViewController assignePersonTaskViewController;

  public ViewHandler(ProjectListModel model)
  {
    currentScene = new Scene(new javafx.scene.layout.Region());
    this.model = model;
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("Main");
  }

  public void openView(String id)
  {
    root = null;
    switch (id)
    {
      case "Main":
        root = loadMain("Main/MainView.fxml");
        break;
      case "TeamMembers":
        root = loadTeamMembers("Main/TeamMembersView.fxml");
        break;
      ////////////////////////DEV///////////////////////////////////
      case "ProjectList":
        root = loadProjectList("Developer/ProjectListView.fxml");
        break;
      case "DeveloperTaskList":
        root = loadDeveloperTaskList("Developer/DeveloperTaskListView.fxml");
        break;
      case "RequirementList":
        root = loadRequirementList("Developer/RequirementListView.fxml");
        break;
      ///////////////////////////CREATOR/////////////////////////////////
      case "ProjectListCreate":
        root = loadProjectListCreate(
            "ProjectCreator/ProjectListCreateView.fxml");
        break;
      case "CreateProject":
        root = loadCreateProject("ProjectCreator/CreateProjectView.fxml");
        break;
      case "AddMember":
        root = loadAddMember("ProjectCreator/AddMemberView.fxml");
        break;
      case "EditProject":
        root = loadEditProject("ProjectCreator/EditProjectView.fxml");
        break;
      case "TeamMemberList":
        root = loadTeamMemberList("ProjectCreator/TeamMemberListView.fxml");
        break;
      case "Role":
        root = loadRole("ProjectCreator/RoleView.fxml");
        break;
      ///////////////////////////////OWNER///////////////////////////////
      case "ProjectListRequirements":
        root = loadProjectListRequirements(
            "ProjectOwner/ProjectListRequirementsView.fxml");
        break;
      case "RequirementsList":
        root = loadRequirementsList("ProjectOwner/RequirementsListView.fxml");
        break;
      case "AddRequirement":
        root = loadAddRequirement("ProjectOwner/AddRequirementView.fxml");
        break;
      case "RequirementAssignePerson":
        root = loadRequirementAssignePerson(
            "ProjectOwner/RequirementAssignePersonView.fxml");
        break;
      case "EditRequirement":
        root = loadEditRequirement("ProjectOwner/EditRequirementView.fxml");
        break;
      ////////////////////////////////SCRUM///////////////////////////////////
      case "AddTask":
        root = loadAddTask("ScrumMaster/AddTaskView.fxml");
        break;
      case "RequirementsListTasks":
        root = loadRequirementsListTasks(
            "ScrumMaster/RequirementsListTasksView.fxml");
        break;
      case "ScrumProjectListRequirements":
        root = loadScrumProjectListRequirements(
            "ScrumMaster/ScrumProjectListRequirementsView.fxml");
        break;
      case "TaskList":
        root = loadTaskList("ScrumMaster/TaskListView.fxml");
        break;
      case "AssignePersonTask":
        root = loadAssignePersonTask("ScrumMaster/AssignePersonTaskView.fxml");
        break;
    }

    currentScene.setRoot(root);
    primaryStage.setScene(currentScene);
    primaryStage.setTitle(id);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  ////////////////////MAIN////////////////////////////////
  public Region loadMain(String fxmlFile)
  {
    if (mainViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        mainViewController = loader.getController();
        mainViewController.init(root, this);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return mainViewController.getRoot();
  }
  public Region loadTeamMembers(String fxmlFile)
  {
    if (teamMembersViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        teamMembersViewController = loader.getController();
        teamMembersViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else{
      teamMembersViewController.reset();
    }
    return teamMembersViewController.getRoot();
  }

  /////////////////DEVELOPER///////////////////////////////
  public Region loadProjectList(String fxmlFile)
  {
    if (projectListViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        projectListViewController = loader.getController();
        projectListViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else {
      projectListViewController.reset();
    }
    return projectListViewController.getRoot();
  }

  public Region loadDeveloperTaskList(String fxmlFile)
  {
    if (developerTaskListViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        developerTaskListViewController = loader.getController();
        developerTaskListViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else {
      developerTaskListViewController.reset();
    }
    return developerTaskListViewController.getRoot();
  }

  public Region loadRequirementList(String fxmlFile)
  {
    if (requirementListViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        requirementListViewController = loader.getController();
        requirementListViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else {
      requirementListViewController.reset();
    }
    return requirementListViewController.getRoot();
  }

  ////////////////////CREATOR/////////////////////////////
  public Region loadProjectListCreate(String fxmlFile)
  {
    if (projectListCreateViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        projectListCreateViewController = loader.getController();
        projectListCreateViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      projectListCreateViewController.reset();
    }
    return projectListCreateViewController.getRoot();
  }

  public Region loadCreateProject(String fxmlFile)
  {
    if (createProjectViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        createProjectViewController = loader.getController();
        createProjectViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      createProjectViewController.reset();
    }
    return createProjectViewController.getRoot();
  }

  public Region loadAddMember(String fxmlFile)
  {
    if (addMemberViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        addMemberViewController = loader.getController();
        addMemberViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else {
      addMemberViewController.reset();
    }
    return addMemberViewController.getRoot();
  }

  public Region loadEditProject(String fxmlFile)
  {
    if (editProjectViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        editProjectViewController = loader.getController();
        editProjectViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }

    return editProjectViewController.getRoot();
  }

  public Region loadTeamMemberList(String fxmlFile)
  {
    if (teamMemberListViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        teamMemberListViewController = loader.getController();
        teamMemberListViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else {
      teamMemberListViewController.reset();
    }
    return teamMemberListViewController.getRoot();
  }

  public Region loadRole(String fxmlFile)
  {
    if (roleViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        roleViewController = loader.getController();
        roleViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return roleViewController.getRoot();
  }

  /////////////////////////////////OWNER////////////////////////////
  public Region loadProjectListRequirements(String fxmlFile)
  {
    if (projectListRequirementsViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        projectListRequirementsViewController = loader.getController();
        projectListRequirementsViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      projectListRequirementsViewController.reset();
    }
    return projectListRequirementsViewController.getRoot();
  }

  public Region loadRequirementsList(String fxmlFile)
  {
    if (requirementsListViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        requirementsListViewController = loader.getController();
        requirementsListViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      requirementsListViewController.reset();
    }

    return requirementsListViewController.getRoot();
  }

  public Region loadAddRequirement(String fxmlFile)
  {
    if (addRequirementViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        addRequirementViewController = loader.getController();
        addRequirementViewController.init(root, this,model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return addRequirementViewController.getRoot();
  }

  public Region loadRequirementAssignePerson(String fxmlFile)
  {
    if (requirementAssignePersonViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        requirementAssignePersonViewController = loader.getController();
        requirementAssignePersonViewController.init(root, this);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return requirementAssignePersonViewController.getRoot();
  }

  public Region loadEditRequirement(String fxmlFile)
  {
    if (editRequirementViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        editRequirementViewController = loader.getController();
        editRequirementViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return editRequirementViewController.getRoot();
  }

  ////////////////////////SCRUM//////////////////////
  public Region loadAddTask(String fxmlFile)
  {
    if (addTaskViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        addTaskViewController = loader.getController();
        addTaskViewController.init(root, this,model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else{
      addTaskViewController.reset();
    }
    return addTaskViewController.getRoot();
  }

  public Region loadRequirementsListTasks(String fxmlFile)
  {
    if (requirementsListTasksViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        requirementsListTasksViewController = loader.getController();
        requirementsListTasksViewController.init(root, this,model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else{
      requirementsListTasksViewController.reset();
    }
    return requirementsListTasksViewController.getRoot();
  }

  public Region loadScrumProjectListRequirements(String fxmlFile)
  {
    if (scrumProjectListRequirementsViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        scrumProjectListRequirementsViewController = loader.getController();
        scrumProjectListRequirementsViewController.init(root, this, model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      scrumProjectListRequirementsViewController.reset();
    }
    return scrumProjectListRequirementsViewController.getRoot();
  }

  public Region loadTaskList(String fxmlFile)
  {
    if (taskListViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        taskListViewController = loader.getController();
        taskListViewController.init(root, this,model);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else{
      taskListViewController.reset();
    }
    return taskListViewController.getRoot();
  }

  public Region loadAssignePersonTask(String fxmlFile)
  {
    if (assignePersonTaskViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        assignePersonTaskViewController = loader.getController();
        assignePersonTaskViewController.init(root, this);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return assignePersonTaskViewController.getRoot();
  }
}
