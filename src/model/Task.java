package model;

public class Task
{
    private TeamMembers list;
    private Time time;
    private StartDate_DeadLine date;
    private String title;
    private String taskID;
    private int estimatedTime;
    private Developer responsibleDeveloper;
    private static final boolean FINISHED = false;
    private static final boolean NOT_STARTED = true;
    private static final boolean STARTED = false;


    public Task(String taskID, String title, int estimatedTime){
        this.taskID = taskID;
        this.title = title;
        this.estimatedTime = estimatedTime;

    }
    public void setResponsibleDeveloper(Developer developer){
        if(list.doesDeveloperExist(developer)){
            responsibleDeveloper = developer;
        }
    }

    public int getEstimatedTime()
    {
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

    public void setTimeSpent(double hours){
        time.setHoursSpent(hours);
    }

    public boolean isTaskStarted()
    {
        return true;
    }

    public boolean isTaskFinished()
    {
        return true;
    }

    public String toStringEstimatedTime(){
        return estimatedTime+"";
    }

}