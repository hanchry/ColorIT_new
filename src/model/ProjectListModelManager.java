package model;

import java.util.ArrayList;

public class ProjectListModelManager implements ProjectListModel {
    private ProjectList list;
    private TeamMembers members;
    public ProjectListModelManager(){
        list = new ProjectList();
    }
    @Override
    public ArrayList<Requirement> getRequirementListOfProject(String title) {
        return null;
    }

    @Override
    public ArrayList<Task> getTasksOfRequirement(Requirement requirement) {
        return null;
    }
    @Override
    public ProjectList getProjects() {
        return null;
    }

    @Override
    public Project getProject(String title) {return null;
    }

    @Override
    public Project getProject(int index) {
      return list.get(index);
    }

    @Override
    public void addProject(Project project) {
        list.Add(project);
    }

    @Override
    public void addRequirementToProject(String title, Requirement requirement) {

    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public int RequirementsListSize() {
        return 0;
    }

    @Override
    public Requirement getRequirement(int index) {
        return null;
    }

    @Override
    public void addDeveloper(String title, Person person) {

    }

    @Override
    public Time showTimeSpentOnRequirement() {
        return null;
    }

    @Override
    public Time showTimeSpentOnTask() {
        return null;
    }

    @Override
    public void setRoleOfTeamMember(Person person, String role) {

    }

    @Override
    public Developer getDeveloper(Developer developer) {
        return null;
    }

    @Override
    public ArrayList<Project> getProjectsByDeveloper(Developer developer) {
        return null;
    }

    @Override
    public StartDate_DeadLine getStartDate() {
        return null;
    }

    @Override
    public StartDate_DeadLine getDeadline() {
        return null;
    }

    @Override
    public int projectListSize() {
       return list.getSize();
    }

    @Override
    public Requirement getRequirement(int indexOfProject, int indexOfRequirement) {
        return null;
    }

    @Override
    public void addRequirement(Requirement requirement) {

    }

    @Override
    public boolean isProjectOpened(int index) {
        return false;
    }

    @Override
    public void setProjectOpened(int index, boolean isOpened) {

    }
}
