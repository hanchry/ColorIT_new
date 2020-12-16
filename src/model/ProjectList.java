package model;

import java.util.ArrayList;

public class ProjectList {

    private ArrayList<Project> projects;

    public ProjectList() {
        projects = new ArrayList<>();
    }

    public void Add(Project project) {
        projects.add(project);
    }

    public Project get(int index) {
        return projects.get(index);
    }

    public int getSize() {
        return projects.size();
    }

    public Project GetByTitle(String title) {
        for (Project project : projects) {
            if (project.getTitle().equals(title)) {
                return project;
            }
        }
        return null;
    }



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


    public Project getByTitle(String title){
        for(Project x:projects){
            if(x.getTitle().equals(title)){
                return x;
            }
        }
        return null;
    }

}