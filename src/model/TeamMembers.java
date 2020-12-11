package model;

import java.util.ArrayList;

public class TeamMembers {
    private ArrayList<Developer> developers;
    private ProjectCreator creator;
    private ScrumMaster scrum;


    public TeamMembers(ProjectCreator creator, ScrumMaster scrum){
        this.creator = creator;
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

    public ProjectCreator getCreator() {
        return creator;
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