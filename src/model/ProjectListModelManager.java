package model;

import java.util.ArrayList;

/**
 * ProjectListModelManager class
 */
public class ProjectListModelManager implements ProjectListModel
{
  private ProjectList list;
  private TeamMembers members;
  private RequirementsList requirementsList;
  private TaskList taskList;
  private ProjectCreator creator;

  /**
   * ProjectListModelManager constractor
   */
  public ProjectListModelManager() {
    list = new ProjectList();
    members = new TeamMembers();
    requirementsList = new RequirementsList();
    taskList = new TaskList();

  }

  /**
   * set method for Creator
   *
   * @param creator creator to be sett
   */
  public void setCreator(ProjectCreator creator){
    this.creator = creator;
  }

  /**
   * get method for requirements of specific project
   *
   * @param title tittle of project
   * @return requirements of given project
   */
  @Override public ArrayList<Requirement> getRequirementListOfProject(
      String title)
  {
    return getRequirementListOfProject(title);
  }

  /**
   * @return all the projects
   */
  @Override public ProjectList getProjects()
  {
    return list;
  }

  /**
   * get method for specific project by tittle
   *
   * @param title tittle of project
   * @return specific project
   */
  @Override public Project getProject(String title)
  {
    return list.getByTitle(title);
  }

  /**
   * get method for specific project by index
   *
   * @param index list index of project
   * @return specific project
   */
  @Override public Project getProject(int index)
  {
    return list.get(index);
  }

  /**
   * add method for project
   *
   * @param project project to be add
   */
  @Override public void addProject(Project project)
  {
    list.Add(project);
  }

  /**
   * get method for specific requirement
   *
   * @param index list index of requirement
   * @return specific requirement
   */
  @Override public Requirement getRequirement(int index)
  {
    return requirementsList.getRequirements().get(index);
  }

  /**
   * get method for size of project list
   *
   * @return size of project list
   */
  @Override public int projectListSize()
  {
    return list.getSize();
  }

  /**
   * get method for project if its opened
   *
   * @param index index of project
   * @return if specific project is opened
   */
  @Override public boolean isProjectOpened(int index)
  {
    return list.get(index).isOpened();
  }

  /**
   * set method for setting if project is opened
   *
   * @param index index of project
   * @param isOpened boolean to set if project is opened
   */
  @Override public void setProjectOpened(int index, boolean isOpened)
  {
    list.get(index).setOpened(isOpened);
  }

  /**
   * remove project method
   *
   * @param project project to be removed
   */
  @Override public void removeProject(Project project)
  {
    list.removeProject(project);
  }

  /**
   * add method for person
   *
   * @param person person to be added
   */
  @Override public void addPerson(Person person) {
    members.addDeveloper(person);
  }

  /**
   * get method for Developer
   *
   * @param index index of developer
   * @return specific developer
   */
  @Override public Developer getDeveloper(int index) {
    return members.getDeveloper(index);
  }

  /**
   * remove method for Developer
   *
   * @param index index of developer
   */
  @Override public void removeDeveloper(int index) {
    members.removeDeveloper(index);
  }

  /**
   * get method for size of developer list
   *
   * @return developer list size
   */
  @Override public int devSize() {
    return members.getDevSize();
  }

  /**
   * add method for Scrum
   *
   * @param scrum ScrumMaster to be added
   */
  @Override public void addScrum(ScrumMaster scrum) {
    members.addScrum(scrum);
  }

  /**
   * add method for Product Owner
   *
   * @param owner owner to be add
   */
  @Override public void addOwner(ProjectOwner owner) {
    members.addOwner(owner);
  }

  /**
   * getter for developers list
   *
   * @return developers list
   */
  @Override public ArrayList<Developer> getDevelopers() {
    return members.getDevelopers();
  }

  /**
   * getter for Scrum Masters list
   *
   * @return Scrums Masters list
   */
  @Override public ArrayList<ScrumMaster> getScrums() {
    return members.getScrums();
  }

  /**
   * getter method for Owners list
   *
   * @return owners list
   */
  @Override public ArrayList<ProjectOwner> getOwners() {
    return members.getOwners();
  }

  /**
   * getter method for Scrum Master
   *
   * @param index index of Scrum Master
   * @return specific Scrum Master
   */
  @Override public ScrumMaster getScrum(int index) {
    return members.getScrum(index);
  }

  /**
   * getter for Project Creator
   *
   * @return project creator
   */
  @Override public ProjectCreator getCreator() {
    return creator;
  }

  /**
   * getter fo Owner list
   *
   * @param index index of Owner
   * @return specific Owner
   */
  @Override public ProjectOwner getOwner(int index) {
    return members.getOwner(index);
  }

  /**
   * remove method for Scrum Master
   *
   * @param index index of Scrum Master
   */
  @Override public void removeScrum(int index) {
    members.removeScrum(index);
  }

  /**
   * remove method for Owner
   *
   * @param index index of Owner
   */
  @Override public void removeOwner(int index) {
    members.removeOwner(index);
  }

}
