package model;


import java.util.ArrayList;

public class Requirement {

    private TeamMembers list;
    private ArrayList<Task> tasks;
    private int neededtime;
    private StartDate_DeadLine date;
    private String ID;
    private String why;
    private String who;
    private String what;
    private boolean isOpened;
    private Developer responsibleDeveloper;
    private static final boolean FINISHED = false;
    private static final boolean APPROVED = false;
    private static final boolean DISAPPROVED = false;

    public Requirement(String ID, String why, String who, String what, int neededtime , StartDate_DeadLine date) {
        this.ID = ID;
        this.why = why;
        this.who = who;
        this.what = what;
        this.date = date;
        this.neededtime = neededtime;
        this.tasks = new ArrayList<>();
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

    public boolean isTaskFinished()
    {
        return false;
    }

    public boolean isTaskApproved()
    {
        return false;
    }

}