package model;

public class Task
{
    private TeamMembers list;

    private Time time;
    private StartDate_DeadLine date;
    private String title;
    private String taskID;
    private Developer responsibleDeveloper;


    public Task(String taskID, String title, int timeEstimatedInHours){
        this.taskID = taskID;
        this.title = title;
        time = new Time(timeEstimatedInHours);
    }
    public void setResponsibleDeveloper(Developer developer){
        if(list.doesDeveloperExist(developer)){
            responsibleDeveloper = developer;
        }
    }


    public Developer getResponsibleDeveloper(){
        return responsibleDeveloper;
    }
    public String getTimeEstimated(){
        return "" + time.getHoursEstimated();
    }
    public String getTimeSpent(){
        return "" + time.getHoursSpent();
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

    public void updateTaskStatus() {

    }

}