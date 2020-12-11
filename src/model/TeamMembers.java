package model;

import java.util.ArrayList;

public class TeamMembers {
    private ArrayList<Developer> developers;
    private ProjectOwner owner;
    private ScrumMaster scrum;


    public TeamMembers(ProjectOwner owner, ScrumMaster scrum){
        this.owner = owner;
        this.scrum = scrum;
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