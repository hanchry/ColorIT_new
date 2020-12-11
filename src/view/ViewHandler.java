package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import view.Developer.DeveloperTaskListViewController;
import view.Developer.ProjectListViewController;
import view.Developer.RequirementListViewController;
import view.Main.MainViewController;
import view.ProjectCreator.AddMemberViewController;
import view.ProjectCreator.CreateProjectViewController;
import view.ProjectCreator.EditProjectViewController;
import view.ProjectCreator.ProjectListCreateViewController;
import view.ProjectOwner.AddRequirementViewController;
import view.ProjectOwner.ProjectListRequirementsViewController;
import view.ProjectOwner.RequirementsListViewController;
import view.ScrumMaster.AddTaskViewController;
import view.ScrumMaster.RequirementsListTasksViewController;
import view.ScrumMaster.ScrumProjectListRequirementsViewController;
import view.ScrumMaster.TaskListViewController;

public class ViewHandler {

  private Scene currentScene;
  private Stage primaryStage;
  private Region root;

  ///////////////////////DEVELOPER/////////////////////////////
  private ProjectListViewController projectListViewController;
  private DeveloperTaskListViewController developerTaskListViewController;
  private RequirementListViewController requirementListViewController;

  //////////////////////MAIN VIEW///////////////////////////
  private MainViewController mainViewController;

  //////////////////////CREATOR////////////////////////////
  private AddMemberViewController addMemberViewController;
  private CreateProjectViewController createProjectViewController;
  private ProjectListCreateViewController projectListCreateViewController;
  private EditProjectViewController editProjectViewController;

  /////////////////////OWNER/////////////////////////////
  private AddRequirementViewController addRequirementViewController;
  private ProjectListRequirementsViewController projectListRequirementsViewController;
  private RequirementsListViewController requirementsListViewController;

  //////////////////////SCRUM//////////////////////////
  private AddTaskViewController addTaskViewController;
  private ScrumProjectListRequirementsViewController scrumProjectListRequirementsViewController;
  private RequirementsListTasksViewController requirementsListTasksViewController;
  private TaskListViewController taskListViewController;


  public ViewHandler(){
    currentScene = new Scene(new javafx.scene.layout.Region());
  }
  public void start(Stage primaryStage){
    this.primaryStage = primaryStage;
    openView("Main");
  }
  public void openView(String id) {
    root = null;
    switch (id) {
      case "Main":
        root = loadMain("Main/MainView.fxml");
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
        root = loadProjectListCreate("ProjectCreator/ProjectListCreateView.fxml");
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
      ///////////////////////////////OWNER///////////////////////////////
      case "ProjectListRequirements":
        root = loadProjectListRequirements("ProjectOwner/ProjectListRequirementsView.fxml");
        break;
      case "RequirementsList":
        root = loadRequirementsList("ProjectOwner/RequirementsListView.fxml");
        break;
      case "AddRequirement":
        root = loadAddRequirement("ProjectOwner/AddRequirementView.fxml");
        break;
      ////////////////////////////////SCRUM///////////////////////////////////
      case "AddTask":
        root = loadAddTask("ScrumMaster/AddTaskView.fxml");
        break;
      case "RequirementsListTasks":
        root = loadRequirementsListTasks("ScrumMaster/RequirementsListTasksView.fxml");
        break;
      case "ScrumProjectListRequirements":
        root = loadScrumProjectListRequirements("ScrumMaster/ScrumProjectListRequirementsView.fxml");
        break;
      case "TaskList":
        root = loadTaskList("ScrumMaster/DeveloperTaskListView.fxml");
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
  public Region loadMain(String fxmlFile){
    if(mainViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        mainViewController = loader.getController();
        mainViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return mainViewController.getRoot();
  }
  /////////////////DEVELOPER///////////////////////////////
  public Region loadProjectList(String fxmlFile){
    if(projectListViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        projectListViewController = loader.getController();
        projectListViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return projectListViewController.getRoot();
  }
  public Region loadDeveloperTaskList(String fxmlFile){
    if(developerTaskListViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        developerTaskListViewController = loader.getController();
        developerTaskListViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return developerTaskListViewController.getRoot();
  }
  public Region loadRequirementList(String fxmlFile){
    if(requirementListViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        requirementListViewController = loader.getController();
        requirementListViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return requirementListViewController.getRoot();
  }
  ////////////////////CREATOR/////////////////////////////
  public Region loadProjectListCreate(String fxmlFile){
    if(projectListCreateViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        projectListCreateViewController = loader.getController();
        projectListCreateViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return projectListCreateViewController.getRoot();
  }
  public Region loadCreateProject(String fxmlFile){
    if(createProjectViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        createProjectViewController = loader.getController();
        createProjectViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return createProjectViewController.getRoot();
  }
  public Region loadAddMember(String fxmlFile){
    if(addMemberViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        addMemberViewController = loader.getController();
        addMemberViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return addMemberViewController.getRoot();
  }
  public Region loadEditProject(String fxmlFile){
    if(editProjectViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        editProjectViewController = loader.getController();
        editProjectViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return editProjectViewController.getRoot();
  }
  /////////////////////////////////OWNER////////////////////////////
  public Region loadProjectListRequirements(String fxmlFile){
    if(projectListRequirementsViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        projectListRequirementsViewController = loader.getController();
        projectListRequirementsViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return projectListRequirementsViewController.getRoot();
  }
  public Region loadRequirementsList(String fxmlFile){
    if(requirementsListViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        requirementsListViewController = loader.getController();
        requirementsListViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return requirementsListViewController.getRoot();
  }
  public Region loadAddRequirement(String fxmlFile){
    if(addRequirementViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        addRequirementViewController = loader.getController();
        addRequirementViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return addRequirementViewController.getRoot();
  }
  ////////////////////////SCRUM//////////////////////
  public Region loadAddTask(String fxmlFile){
    if(addTaskViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        addTaskViewController = loader.getController();
        addTaskViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return addTaskViewController.getRoot();
  }
  public Region loadRequirementsListTasks(String fxmlFile){
    if(requirementsListTasksViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        requirementsListTasksViewController = loader.getController();
        requirementsListTasksViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return requirementsListTasksViewController.getRoot();
  }
  public Region loadScrumProjectListRequirements(String fxmlFile){
    if(scrumProjectListRequirementsViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        scrumProjectListRequirementsViewController = loader.getController();
        scrumProjectListRequirementsViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return scrumProjectListRequirementsViewController.getRoot();
  }
  public Region loadTaskList(String fxmlFile){
    if(taskListViewController == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        taskListViewController = loader.getController();
        taskListViewController.init(root,this);
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    return taskListViewController.getRoot();
  }
}
