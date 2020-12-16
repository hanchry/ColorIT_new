package model;

public class Task
{
    private TeamMembers list;
    private Time time;
    private StartDate_DeadLine date;
    private String title;
    private int taskID;
    private int estimatedTime;
    private Developer responsibleDeveloper;

    private boolean finished;

    public Task(int taskID, String title, int estimatedTime){
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

    public void setResponsibleDeveloper(Developer developer){
        if(list.doesDeveloperExist(developer)){
            responsibleDeveloper = developer;
        }
    }




    public String getEstimatedTime()
    {
        return estimatedTime+"";
    }

    public Developer getResponsibleDeveloper(){
        return responsibleDeveloper;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int ID)
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


}