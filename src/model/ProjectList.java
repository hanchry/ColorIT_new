package model;

import java.util.ArrayList;

/**
 * ProjectList class
 */
public class ProjectList {

    private ArrayList<Project> projects;

    /**
     * ProjectList constructor
     */
    public ProjectList() {
        projects = new ArrayList<>();
    }

    /**
     * add method for adding projects to lsit
     *
     * @param project project object
     */
    public void Add(Project project) {
        projects.add(project);
    }

    /**
     * specific project getter
     *
     * @param index list index of project
     * @return specific project form list
     */
    public Project get(int index) {
        return projects.get(index);
    }

    /**
     * getter for size of project list
     *
     * @return size of project list
     */
    public int getSize() {
        return projects.size();
    }

    /**
     * remove method for project lsit
     *
     * @param project to be removed
     */
    public void removeProject(Project project){
        for (int i = 0; i < projects.size(); i++)
        {
            if (projects.get(i).getTitle().equals(project.getTitle()))
            {
                projects.remove(i);
                break;
            }
        }
    }

    /**
     * specific project getter
     *
     * @param title tittle of project
     * @return specific project by tittle
     */
    public Project getByTitle(String title){
        for(Project x:projects){
            if(x.getTitle().equals(title)){
                return x;
            }
        }
        return null;
    }

}