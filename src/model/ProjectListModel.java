package model;

import javafx.collections.ObservableList;
import java.util.ArrayList;

/**
 * ProjectListModel interface
 */
public interface ProjectListModel {

    /**
     * getter for requirements in project
     *
     * @param title tittle of project
     * @return requirements list of project
     */
    ArrayList<Requirement> getRequirementListOfProject(String title);

    /**
     * getter for projects
     *
     * @return projects list
     */
    ProjectList getProjects();

    /**
     * getter for project
     *
     * @param title tittle of project
     * @return project of given parameter
     */
    Project getProject(String title);

    /**
     * getter for project
     *
     * @param index list index of project
     * @return project of given parameter
     */
    Project getProject(int index);

    /**
     * adder for adding project to projects list
     *
     * @param project project to be add
     */
    void addProject(Project project);

    /**
     * getter for specific requirement
     *
     * @param index list index of requirement
     * @return requirement by index
     */
    Requirement getRequirement(int index);


    /**
     * getter for size of projects list
     *
     * @return size of projects list
     */
    int projectListSize();

    /**
     * getter for isProjectOpened
     *
     * @param index index of project
     * @return if is project opened
     */
    boolean isProjectOpened(int index);

    /**
     * setter for isProjectOpened
     *
     * @param index index of project
     * @param isOpened boolean to set if project is opened
     */
    void setProjectOpened(int index, boolean isOpened);

    /**
     * remove method for Project
     *
     * @param project project to be removed
     */
    void removeProject(Project project);

    /**
     * add method for person
     *
     * @param person person to be added
     */
    void addPerson(Person person);

    /**
     * getter for developer
     *
     * @param index index of developer
     * @return specific developer
     */
    Developer getDeveloper(int index);

    /**
     * remove method for developer
     *
     * @param index index of developer
     */
    void removeDeveloper(int index);

    /**
     * getter for developer list size
     *
     * @return size od developer list
     */
    int devSize();

    /**
     * add method for ScrumMaster
     *
     * @param scrum ScrumMaster to be added
     */
    void addScrum(ScrumMaster scrum);

    /**
     * add method for Product Owner
     *
     * @param owner owner to be add
     */
    void addOwner(ProjectOwner owner);

    /**
     * getter for developers list
     *
     * @return developers list
     */
    ArrayList<Developer> getDevelopers();

    /**
     * getter for Scrum Masters list
     *
     * @return Scrums Masters list
     */
    ArrayList<ScrumMaster> getScrums();

    /**
     * getter method for Owners list
     *
     * @return owners list
     */
    ArrayList<ProjectOwner> getOwners();

    /**
     * getter method for Scrum Master
     *
     * @param index index of Scrum Master
     * @return specific Scrum Master
     */
    ScrumMaster getScrum(int index);

    /**
     * getter for Project Creator
     *
     * @return project creator
     */
    ProjectCreator getCreator();

    /**
     * getter fo Owner list
     *
     * @param index index of Owner
     * @return specific Owner
     */
    ProjectOwner getOwner(int index);

    /**
     * remove method for Scrum Master
     *
     * @param index index of Scrum Master
     */
    void removeScrum(int index);

    /**
     * remove method for Owner
     *
     * @param index index of Owner
     */
    void removeOwner(int index);

    /**
     * setter for Creator
     *
     * @param creator creator to be sett
     */
    void setCreator(ProjectCreator creator);
}
