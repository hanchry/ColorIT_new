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
     * finds requirement by parameters given and removes it
     *
     * @param title title of requirement
     * @param who who of requirement
     */
    public void removeRequirement(String title, String who){
        for(int x = 0; x < requirements.size(); x++){
            if (requirements.get(x).getTitle().equals(title) && requirements.get(x).getWho().equals(who)){
                requirements.remove(x);
            }
        }
    }

    /**
     * startDate_deadline getter
     *
     * @return start and deadline
     */
    public StartDate_DeadLine getStart_deadLine() {
        return startDate_deadLine;
    }

    /**
     * startDate_deadline setter
     *
     * @param deadline deadline to set
     */
    public void setStartDate_deadLine(StartDate_DeadLine deadline) {
        this.startDate_deadLine = deadline;
    }

    /**
     * team member getter
     *
     * @param index index of specific team member in team member list
     * @return team member from list
     */
    public TeamMembers getTeamMembers(int index) {
        return teamMembers.get(index);
    }

    /**
     * title getter
     *
     * @return title of project
     */
    public String getTitle() {
        return title;
    }

    /**
     * title setter
     *
     * @param title title to set in project
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * requirements list getter
     *
     * @return all requirements of project
     */
    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }

    /**
     * specific requirement getter
     *
     * @param index list index of requirement
     * @return requirement
     */
    public Requirement getRequirement(int index) {
        return requirements.get(index);
    }

    /**
     * isOpened getter
     *
     * @return if project is opened
     */
    public boolean isOpened() {
        return isOpened;
    }

    /**
     * isOpened setter
     *
     * @param opened variable (boolean) which sets if project is opened
     */
    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    /**
     * toString method
     *
     * @return project variables
     */
    public String toString() {
        return " " + title + " " + startDate_deadLine;
    }

    /**
     * status getter
     * compares time spent and time estimeted to set status
     * compares approved requirements in project to set status
     *
     * @return status of project
     */
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

    /**
     * getter for amount of approved requirements
     *
     * @return how many requirements were approved
     */
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
