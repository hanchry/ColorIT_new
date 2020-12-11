package model;

import java.util.ArrayList;

public class TeamMembers {
    private ArrayList<Developer> developers;
    private ProjectCreator creator;
    private ScrumMaster scrum;
    private ProjectOwner owner;

    public TeamMembers(ProjectCreator creator, ScrumMaster scrum, ProjectOwner owner){
        this.creator = creator;
        this.scrum = scrum;
        this.owner = owner;
        developers = new ArrayList<>();
    }
    public void addDeveloper(Person person){
        developers.add((Developer)person);
    }

    public ArrayList<Developer> getDevelopers() {
        return developers;
    }
    public Developer getDeveloper(int index){
        return developers.get(index);
    }

    public ProjectCreator getCreator() {
        return creator;
    }

    public ProjectOwner getOwner() {
        return owner;
    }

    public ScrumMaster getScrum() {
        return scrum;
    }
    public boolean doesDeveloperExist(Developer developer){
        for (int x = 0; x < developers.size(); x++){
            if(developers.get(x) == developer){
                return true;
            }
        }
        return false;
    }
}