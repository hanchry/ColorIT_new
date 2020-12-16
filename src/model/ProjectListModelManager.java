package model;

import java.util.ArrayList;

public class ProjectListModelManager implements ProjectListModel
{
  private ProjectList list;
  private TeamMembers members;
  private RequirementsList requirementsList;
  private TaskList taskList;
  private ProjectCreator creator;

  public ProjectListModelManager() {
    list = new ProjectList();
    members = new TeamMembers();
    requirementsList = new RequirementsList();
    taskList = new TaskList();

  }

  public void setCreator(ProjectCreator creator){
    this.creator = creator;
  }



  @Override public ArrayList<Requirement> getRequirementListOfProject(
      String title)
  {
    return getRequirementListOfProject(title);
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


  @Override public Requirement getRequirement(int index)
  {
    return requirementsList.getRequirements().get(index);
  }


  @Override
  public void setTimeEstimated(String timeEstimated) {

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
