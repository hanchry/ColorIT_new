package model;


import java.util.ArrayList;
import java.util.Random;

public class Requirement {

    private ArrayList<TeamMembers> list;
    private ArrayList<Task> tasks;
    private int neededtime;
    private StartDate_DeadLine date;
    private String title;
    private String ID;
    private String why;
    private String who;
    private String what;
    private boolean isOpened;
    private Developer responsibleDeveloper;
    private int timeSpent;

    private Random r;
    private int id;

    private  boolean finished;
    private  boolean approved;
    private  boolean disapproved;

    public Requirement(String title, String why, String who, String what, StartDate_DeadLine date) {
        r = new Random();
        id = r.nextInt();
        if (id < 0){
            id *= -1;
        }
        this.title = title;
        this.ID = "" + id;
        this.why = why;
        this.who = who;
        this.what = what;
        this.date = date;
        this.neededtime = 0;
        this.timeSpent = 0;
        this.tasks = new ArrayList<>();
        this.finished = false;
        this.approved = false;
        this.disapproved = false;

    }
    public Requirement(String title, String who){
        this.title = title;
        this.who = who;
    }

    public void setRequirementApproved()
    {
        if (disapproved)
        {
            approved = false;
        }
        approved = true;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }
    public void removeTask(int index){
        tasks.remove(index);
    }

    public int getTimeSpent() {
        if(tasks != null){
            this.timeSpent = 0;
            for(int x = 0; x < tasks.size(); x++){
                this.timeSpent += tasks.get(x).getTimeDone();
            }
        }
        else {
            timeSpent = 0;
        }
        return timeSpent;
    }

    public String getTitle() {
        return title;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public void setWhat(String what) {
        this.what = what;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(StartDate_DeadLine date) {
        this.date = date;
    }

    public void setNeededtime() {
        for(int x = 0; x < tasks.size(); x++){
            this.neededtime += tasks.get(x).getTime();
        }
    }

    public boolean setRequirementFinished()
    {
        for (int i = 0; i < tasks.size(); i++)
        {
            if (!tasks.get(i).isFinished())
            {
                this.finished = false;
            }
            this.finished = true;
        }
        return false;
    }

    public void setRequirementDisapproved()
    {
        if (approved)
        {
            disapproved = false;
        }
        disapproved = true;
    }
    public boolean doesTeamMemberExist(TeamMembers member) {
        for (TeamMembers teamMembers : list) {
            if (teamMembers == member) {
                return true;
            }
        }
        return false;
    }

    public void setResponsibleDeveloper(Developer developer)
    {
        responsibleDeveloper = developer;
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

    public ArrayList<TeamMembers> getList() {
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
        if(tasks != null){
            neededtime = 0;
            for(int x = 0; x < tasks.size(); x++){
                neededtime += tasks.get(x).getTime();
            }
        }
        return neededtime+"";
    }
    public int getTime()
    {
        if(tasks != null){
            neededtime = 0;
            for(int x = 0; x < tasks.size(); x++){
                neededtime += tasks.get(x).getTime();
            }
        }
        return neededtime;
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