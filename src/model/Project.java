package model;

import java.util.ArrayList;

public class Project {
    private StartDate_DeadLine startDate_deadLine;
    private String title;
    private TeamMembers teamMembers;
    private boolean isOpened;
    private ArrayList<Requirement> requirements;

    public Project(String title, StartDate_DeadLine startDeadLine) {
        this.title = title;
        this.requirements = new ArrayList<>();
        this.teamMembers = teamMembers;
        this.startDate_deadLine = startDeadLine;
        this.isOpened = false;
    }
    public void addRequriement(Requirement requirement) {
        requirements.add(requirement);
    }

    public StartDate_DeadLine getStart_deadLine() {
        return startDate_deadLine;
    }


    public TeamMembers getTeamMembers()
    {
        return teamMembers;
    }
    public String getTitle(){return title;}



    public void Edit(String title, Requirement requirement, StartDate_DeadLine startDeadLine) {
        this.title = title;
        this.addRequriement(requirement);
        this.startDate_deadLine = startDeadLine;

    }

    public Requirement getRequirement(String title)
    {
        return null;
    }

    public ArrayList<Requirement> getRequirements(){
        return requirements;
    }

    public Requirement getRequirement(int index)
    {
        return requirements.get(index);
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public String toString() {
        return " "+title+" " + startDate_deadLine +" " + teamMembers + " " + requirements;
    }
}
