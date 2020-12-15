package model;

import java.util.ArrayList;

public class Project {

    public Time time;
    private ArrayList<Person> people;
    private ProjectCreator projectCreator;
    private StartDate_DeadLine startDate_deadLine;
    private String title;
    private ArrayList<TeamMembers> teamMembers;
    private boolean isOpened;
    private ArrayList<Requirement> requirements;



    private boolean finished;


    public Project(String title, StartDate_DeadLine startDeadLine, Time estimetedTime) {
        this.time = estimetedTime;
        this.title = title;
        this.requirements = new ArrayList<>();
        teamMembers = new ArrayList<>();
        this.startDate_deadLine = startDeadLine;
        this.isOpened = false;
        this.finished = false;
    }


    public void setFinishProject() {
        for (int i = 0; i < requirements.size(); i++) {
            if (requirements.get(i).setRequirementFinished()) {
                this.finished = true;
            }
        }
        this.finished = false;
    }

    public Project(String title) {
        this.title = title;
    }

    public ProjectCreator getProjectCreator() {
        return projectCreator;
    }

    public void removePerson(Person person) {
        people.remove(person);
    }

    public void createProject(String title, StartDate_DeadLine startDate_deadLine, ArrayList<TeamMembers> role, ArrayList<Person> people) {
        this.title = title;
        this.startDate_deadLine = startDate_deadLine;
        this.teamMembers = role;
        this.people = people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }


    public String getHoursEstimated() {
        return time.toStringHoursEstimated();
    }

    public void setTimeEstimated(String timeEstimated) {
        time.setHoursEstimated(timeEstimated);
    }


    public String getHoursSpent() {
        return time.toStringHoursSpent();
    }

    public void addRequriement(Requirement requirement) {
        requirements.add(requirement);
    }

    public void removeRequirement(String title, String who){
        for(int x = 0; x < requirements.size(); x++){
            if (requirements.get(x).getTitle().equals(title) && requirements.get(x).getWho().equals(who)){
                requirements.remove(x);
            }
        }
    }

    public StartDate_DeadLine getStart_deadLine() {
        return startDate_deadLine;
    }

    public void setStartDate_deadLine(StartDate_DeadLine deadline) {
        this.startDate_deadLine = deadline;
    }

    public TeamMembers getTeamMembers(int index) {
        return teamMembers.get(index);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void Edit(String title, Requirement requirement, StartDate_DeadLine startDeadLine) {
        this.title = title;
        this.addRequriement(requirement);
        this.startDate_deadLine = startDeadLine;
    }

    public Requirement getRequirement(String title) {
        return null;
    }

    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }

    public Requirement getRequirement(int index) {
        return requirements.get(index);
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public String toString() {
        return " " + title + " " + startDate_deadLine;
    }


}
