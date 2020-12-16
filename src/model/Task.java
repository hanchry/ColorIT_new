package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * task class
 */
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

    /**
     * Task constructor
     * @param title title of task
     * @param estimatedTime estimated time of task
     */
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

    /**
     * set method for time spent on task
     * @param timeDone time spent
     */
    public void setTimeDone(int timeDone) {
        this.timeDone = timeDone;
    }

    /**
     * get method for task time spent
     * @return time spent
     */
    public int getTimeDone() {
        return timeDone;
    }

    /**
     * set method to set responsible Developer
     * @param developer responsible Developer
     */
    public void setResponsibleDeveloper(Developer developer)
    {
        responsibleDeveloper = developer;
    }

    /**
     * get method for estimated time of Task
     * @return estimated time
     */
    public String getEstimatedTime()
    {
        return estimatedTime + "";
    }

    /**
     * get method for estimated time of Task
     * @return estimated time
     */
    public int getTime(){
        return estimatedTime;
    }

    /**
     * get method for responsible Developer
     * @return responsible Developer
     */
    public Developer getResponsibleDeveloper(){
        return responsibleDeveloper;
    }

    /**
     * get method for task ID
     * @return task Id
     */
    public String getTaskID() {
        return taskID;
    }

    /**
     * ste method for Task ID
     * @param ID task ID
     */
    public void setTaskID(String ID)
    {
        this.taskID = ID;
    }

    /**
     * get method for Tittle of task
     * @return Tittle of task
     */
    public String getTitle() {
        return title;
    }

    /**
     * get method for if is task opened
     * @return if task is opened
     */
    public boolean isOpened(){
        return isOpened;
    }

    /**
     * set method for if task is opened
     * @param isOpened if task is opened
     */
    public void setIsOpened(boolean isOpened){
        this.isOpened = isOpened;
    }

    /**
     * get method for task status
     * method gets status by checking time spend and estimated
     * @return status of task
     */
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