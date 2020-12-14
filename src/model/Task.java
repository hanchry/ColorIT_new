package model;

import java.util.ArrayList;

public class Task
{
    private ArrayList<TeamMembers> list;
    private Time time;
    private StartDate_DeadLine date;
    private String title;
    private String taskID;
    private int estimatedTime;
    private Developer responsibleDeveloper;

    private boolean finished;


    public Task(String taskID, String title, int estimatedTime){
        this.taskID = taskID;
        this.title = title;
        this.estimatedTime = estimatedTime;
        this.finished = false;
    }

    public boolean isFinished()
    {
        return finished;
    }

    public void finishTask()
    {
        this.finished = true;
    }

    public boolean doesTeamMemberExist(TeamMembers member) {
        for (TeamMembers teamMembers : list) {
            if (teamMembers == member) {
                return true;
            }
        }
        return false;
    }

    public void setResponisbleTeamMember(TeamMembers member)
    {
        if (doesTeamMemberExist(member))
        {
            list.add(member);
        }
    }

    public String getEstimatedTime()
    {
        return estimatedTime + " ";
    }

    public Developer getResponsibleDeveloper(){
        return responsibleDeveloper;
    }

    public String getTaskID() {
        return taskID;
    }
    public void setTaskID(String ID)
    {
        this.taskID = ID;
    }

    public String getTitle() {
        return title;
    }

    public boolean isTaskStarted()
    {
        return true;
    }

    public boolean isTaskFinished()
    {
        return true;
    }


}