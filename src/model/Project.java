package model;

import java.util.ArrayList;

/**
 * Project class
 */
public class Project {

    public int time;
    private ProjectCreator projectCreator;
    private StartDate_DeadLine startDate_deadLine;
    private String title;
    private ArrayList<TeamMembers> teamMembers;
    private boolean isOpened;
    private ArrayList<Requirement> requirements;
    private int timeSpendet;

    /**
     * constructor of Project
     *
     * @param title title of project
     * @param startDeadLine start and deadline of project
     */
    public Project(String title, StartDate_DeadLine startDeadLine) {
        this.time = 0;
        this.timeSpendet = 0;
        this.title = title;
        this.requirements = new ArrayList<>();
        teamMembers = new ArrayList<>();
        this.startDate_deadLine = startDeadLine;
        this.isOpened = false;

    }

    /**
     * getter for time spend
     *
     * @return time spend on project
     */
    public int getTimeSpendet() {
        if (requirements != null){
            timeSpendet = 0;
            for(int x = 0; x < requirements.size(); x++){
                timeSpendet += requirements.get(x).getTimeSpent();
            }
        }
        else {
            timeSpendet = 0;
        }
        return timeSpendet;
    }

    /**
     * constructor of Project
     *
     * @param title title of project
     */
    public Project(String title) {
        this.title = title;
    }

    /**
     * project creator getter
     *
     * @return project creator person
     */
    public ProjectCreator getProjectCreator() {
        return projectCreator;
    }

    /**
     * hours estimated getter
     *
     * @return estimated hours
     */
    public String getHoursEstimated() {

        if(requirements != null){
            this.time = 0;
            for(int x = 0; x < requirements.size(); x++){
                this.time += requirements.get(x).getTime();
            }
        }

        return time + "";
    }

    /**
     * estimated time setter
     * sets estimated time by putting requirements estimated time sum together
     */
    public void setTimeEstimated() {
        if(requirements != null){
            this.time = 0;
            for(int x = 0; x < requirements.size(); x++){
                this.time += requirements.get(x).getTime();
            }
        }
        else {
            this.time = 0;
        }
    }

    /**
     * add requirement to list method
     *
     * @param requirement requirement to be addet to list of requirements
     */
    public void addRequriement(Requirement requirement) {
        requirements.add(requirement);
    }

    /**
     * remove requirement from list method
     *
     * @param title title of requirement
     * @param who
     */
    public void removeRequirement(String title, String who){
        for(int x = 0; x < requirements.size(); x++){
            if (requirements.get(x).getTitle().equals(title) && requirements.get(x).getWho().equals(who)){
                requirements.remove(x);
            }
        }
    }

    /**
     *
     * @return start and deadline
     */
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

    public String getStatus(){
        int approved = 0;
        if(requirements.size() > 0) {
            for (int x = 0; x < requirements.size(); x++) {
                if (requirements.get(x).getApproved()) {
                    approved++;
                }
            }
            if (approved == requirements.size()) {
                return "finished";
            }
        }
        if (0 >= timeSpendet){
            return "not started";
        }
        return "in progress";
    }
    public String getAmountOfApprovedRequirements(){
        int approved = 0;
        if(requirements.size() > 0) {
            for (int x = 0; x < requirements.size(); x++) {
                if (requirements.get(x).getApproved()) {
                    approved++;
                }
            }
        }
        return approved + "/" + requirements.size();
    }

}
