package model;


import java.util.ArrayList;

public class Requirement {

    private TeamMembers list;
    private ArrayList<Task> tasks;
    private Time time;
    private StartDate_DeadLine date;
    private String ID;
    private String why;
    private String who;
    private String what;
    private Developer responsibleDeveloper;

    public Requirement(String ID, String why, String who, String what){
        this.ID = ID;
        this.why = why;
        this.who = who;
        this.what = what;
        this.date = date;
        this.time = time;
    }
    public void setResponsibleDeveloper(Developer developer){
        if(list.doesDeveloperExist(developer)){
            responsibleDeveloper = developer;
        }
    }


    public void addTask(Task task){
        tasks.add(task);
    }
    public Task getTask(int index){
        return tasks.get(index);
    }
    public int getTaskListSize(){
        return tasks.size();
    }

    public String toString(){
        return " " + ID + " " + why + " " + who + " " + what + " " + responsibleDeveloper + " " + date + " " + time;
    }


    public Developer getResponsibleDeveloper()
    {
        return responsibleDeveloper;
    }
    public String getResponsibleDeveloperString()
    {
        return responsibleDeveloper.toString();
    }

    public String getID()
    {
        return ID;
    }

    public String getWho()
    {
        return who;
    }

    public TeamMembers getList()
    {
        return list;
    }

    public String getWhat()
    {
        return what;
    }

    public String getWhy()
    {
        return why;
    }
    public String getNeededTime()
    {
        return time.toString();
    }

    public String getDeadLine()
    {
        return date.toString();
    }
}
