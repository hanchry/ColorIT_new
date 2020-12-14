package model;

import java.util.ArrayList;

public class ProjectListModelManager implements ProjectListModel
{
  private ProjectList list;
  private TeamMembers members;
  private RequirementsList requirementsList;
  private TaskList taskList;
  private ProjectCreator creator;

  public void setCreator(ProjectCreator creator){
    this.creator = creator;
  }


  public ProjectListModelManager()
  {
    creator = null;
    requirementsList = new RequirementsList();
    list = new ProjectList();
    members = new TeamMembers();
  }

  @Override public ArrayList<Requirement> getRequirementListOfProject(
      String title)
  {
    return getRequirementListOfProject(title);
  }

  @Override public ArrayList<Task> getTasksOfRequirement(
      Requirement requirement)
  {
    return null;
  }

  @Override public ProjectList getProjects()
  {
    return list;
  }

  @Override public Project getProject(String title)
  {
    return list.getByTitle(title);
  }

  @Override public Project getProject(int index)
  {
    return list.get(index);
  }

  @Override public void addProject(Project project)
  {
    list.Add(project);
  }

  @Override public void addRequirementToProject(String title,
      Requirement requirement)
  {
    requirementsList.add(requirement);

  }

  @Override public void addTask(Task task)
  {
    taskList.add(task);
  }

  @Override public int RequirementsListSize()
  {
    return requirementsList.getSize();
  }

  @Override public Requirement getRequirement(int index)
  {
    return requirementsList.getRequirements().get(index);
  }

  @Override public void addDeveloper(String title, Person person)
  {

  }

  @Override
  public void setTimeEstimated(String timeEstimated) {

  }

  @Override public Time showTimeSpentOnRequirement()
  {
    return null;
  }

  @Override public Time showTimeSpentOnTask()
  {
    return null;
  }

  @Override public void setRoleOfTeamMember(Person person, String role)
  {

  }

  @Override public Developer getDeveloper(Developer developer)
  {
    return null;
  }

  @Override public ArrayList<Project> getProjectsByDeveloper(
      Developer developer)
  {
    return null;
  }

  @Override public StartDate_DeadLine getStartDate()
  {
    return null;
  }

  @Override public StartDate_DeadLine getDeadline()
  {
    return null;
  }

  @Override public int projectListSize()
  {
    return list.getSize();
  }



  @Override public Requirement getRequirement(int indexOfProject,
      int indexOfRequirement)
  {
    return list.get(indexOfProject).getRequirement(indexOfRequirement);
  }

  @Override public void addRequirement(Requirement requirement)
  {
    requirementsList.add(requirement);
  }

  @Override public boolean isProjectOpened(int index)
  {
    return list.get(index).isOpened();
  }

  @Override public void setProjectOpened(int index, boolean isOpened)
  {
    list.get(index).setOpened(isOpened);
  }

  @Override public void removeProject(Project project)
  {
    list.removeProject(project);
  }

  @Override public void addPerson(Person person) {
    members.addDeveloper(person);
  }

  @Override public Developer getDeveloper(int index) {
    return members.getDeveloper(index);
  }


  @Override public void removeDeveloper(int index) {
    members.removeDeveloper(index);
  }

  @Override public int devSize() {
    return members.getDevSize();
  }

  @Override public void addScrum(ScrumMaster scrum) {
    members.addScrum(scrum);
  }

  @Override public void addOwner(ProjectOwner owner) {
    members.addOwner(owner);
  }

  @Override public ArrayList<Developer> getDevelopers() {
    return members.getDevelopers();
  }

  @Override public ArrayList<ScrumMaster> getScrums() {
    return members.getScrums();
  }

  @Override public ArrayList<ProjectOwner> getOwners() {
    return members.getOwners();
  }

  @Override public ScrumMaster getScrum(int index) {
    return members.getScrum(index);
  }

  @Override public ProjectCreator getCreator() {
    return creator;
  }


  @Override public ProjectOwner getOwner(int index) {
    return members.getOwner(index);
  }

  @Override public void removeScrum(int index) {
    members.removeScrum(index);
  }

  @Override public void removeOwner(int index) {
    members.removeOwner(index);
  }

}
