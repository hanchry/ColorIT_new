package model;

import javafx.collections.ObservableList;
import java.util.ArrayList;

public interface ProjectListModel {

    ArrayList<Requirement> getRequirementListOfProject(String title);
    ProjectList getProjects();
    Project getProject(String title);
    Project getProject(int index);
    void addProject(Project project);
    Requirement getRequirement(int index);
    void setTimeEstimated(String timeEstimated);
    StartDate_DeadLine getStartDate();
    StartDate_DeadLine getDeadline();
    int projectListSize();
    Requirement getRequirement(int indexOfProject, int indexOfRequirement);
    boolean isProjectOpened(int index);
    void setProjectOpened(int index, boolean isOpened);
    void removeProject(Project project);
    void addPerson(Person person);
    Developer getDeveloper(int index);
    void removeDeveloper(int index);
    int devSize();
    void addScrum(ScrumMaster scrum);
    void addOwner(ProjectOwner owner);
    ArrayList<Developer> getDevelopers();
    ArrayList<ScrumMaster> getScrums();
    ArrayList<ProjectOwner> getOwners();
    ScrumMaster getScrum(int index);
    ProjectCreator getCreator();
    ProjectOwner getOwner(int index);
    void removeScrum(int index);
    void removeOwner(int index);
    void setCreator(ProjectCreator creator);
}
