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

    public Project getByProjectOwner(ProjectOwner owner) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getTeamMembers(i).getOwner() == owner) {
                return projects.get(i);
            }
        }
        return null;
    }

    public Project getByScrumMaster(ScrumMaster scrumMaster) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getTeamMembers(i).getScrum() == scrumMaster) {
                return projects.get(i);
            }
        }
        return null;
    }

    public Project getByDeveloper(Developer developer) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getTeamMembers(i).getDeveloper(i) == developer) {
                projects.get(i);
            }
        }
        return null;
    }

    public Project getByRequirement(Requirement requirement) {
        return null;
    }

    public Project getByDates(MyDate date)
    {
        for (int i =0; i< projects.size(); i++)
        {
            if (projects.get(i).getStart_deadLine().getMyDateDeadline() == date)
            {
                return projects.get(i);
            }
        }
        return null;
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