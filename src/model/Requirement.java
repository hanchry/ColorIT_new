package model;


import java.sql.Struct;
import java.util.ArrayList;

public class Requirement {

    private TeamMembers list;
    private TaskList tasks;
    private int neededtime;
    private StartDate_DeadLine date;
    private String ID;
    private String why;
    private String who;
    private String what;
    private boolean isOpened;
    private Developer responsibleDeveloper;
    private  boolean finished;
    private  boolean approved;
    private  boolean dispparoved;

    public Requirement(String ID, String why, String who, String what, int neededtime , StartDate_DeadLine date) {
        this.ID = ID;
        this.why = why;
        this.who = who;
        this.what = what;
        this.date = date;
        this.neededtime = neededtime;
        this.tasks = new ArrayList<>();
        this.finished = false;
        this.approved = false;
        this.dispparoved = false;
    }

    public void setRequirementApproved()
    {
        if (dispparoved)
        {
            approved = false;
        }
        approved = true;
    }

    public void setRequirementFinished()
    {
        for (int i = 0; i < tasks.getSize(); i++)
        {
            if (tasks.getTask(i).isFinished() == false)
            {
                this.finished = false;
            }
            this.finished = true;
        }
    }

        //// change spelling on disapprove

    public void setRequirementDisapproved()
    {
        if (approved)
        {
            dispparoved = false;
        }
        dispparoved = true;
    }

    public void setResponsibleDeveloper(Developer developer) {
        if (list.doesDeveloperExist(developer)) {
            responsibleDeveloper = developer;
        }
    }

    public void addTask(Task task)
    {
        tasks.add(task);
    }

    public Task getTask(int index)
    {
        return tasks.get(index);
    }

    public int getTaskListSize()
    {
        return tasks.size();
    }

    public Developer getResponsibleDeveloper() {
        return responsibleDeveloper;
    }

    public String getResponsibleDeveloperString() {
        return responsibleDeveloper.toString();
    }

    public String getID() {
        return ID;
    }

    public String getWho() {
        return who;
    }

    public TeamMembers getList() {
        return list;
    }

    public String getWhat() {
        return what;
    }

    public String getWhy() {
        return why;
    }

    public String getStartDate()
    {
        return date.getMyDateStartDate().toString();
    }
    public String getDeadLine() {
        return  date.getMyDateDeadline().toString();
    }

    public String getNeededtime()
    {
        return neededtime+"";
    }

    public boolean isOpened()
    {
        return isOpened;
    }

    public void setOpened(boolean opened)
    {
        isOpened = opened;
    }

    public String toString() {
        return " " + ID + " " + why + " " + who + " " + what + " " + responsibleDeveloper + " " + date + " " + neededtime;
    }

    public boolean isTaskFinished(Task task)
    {
        return tasks.specificTask(task).isFinished();
    }

}