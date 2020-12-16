package model;

import java.util.ArrayList;
import java.util.Random;

public class Task
{
    private ArrayList<TeamMembers> list;
    private Time time;
    private StartDate_DeadLine date;
    private String title;
    private String taskID;
    private int estimatedTime;
    private Developer responsibleDeveloper;
    private boolean isOpened;
    private int timeDone;

    private Random r;
    private int id;



    public Task( String title, int estimatedTime){
        r = new Random();
        id = r.nextInt();
        if (id < 0){
            id *= -1;
        }
        this.title = title;
        this.timeDone = 0;
        this.taskID = "" + id;
        this.estimatedTime = estimatedTime;
        this.isOpened = false;
    }


    public void setTimeDone(int timeDone) {
        this.timeDone = timeDone;
    }

    public int getTimeDone() {
        return timeDone;
    }


    public void setResponsibleDeveloper(Developer developer)
    {
        responsibleDeveloper = developer;
    }

    public String getEstimatedTime()
    {
        return estimatedTime + "";
    }

    public int getTime(){
        return estimatedTime;
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


    public boolean isOpened(){
        return isOpened;
    }
    public void setIsOpened(boolean isOpened){
        this.isOpened = isOpened;
    }

    public String getTaskStatus(){
        if (timeDone == 0){
            return "not started";
        }
        if (timeDone < estimatedTime){
            return "in progress";
        }
        return "finished";
    }
}