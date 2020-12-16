package model;


import java.util.ArrayList;
import java.util.Random;

/**
 * Requirement class
 */
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
    private String requirementStatus;

    private Random r;
    private int id;

    private boolean isApproved;
    private boolean isDisapproved;

    private  boolean approved;
    private  boolean disapproved;

    /**
     * Requirement constructor with 5 parameters
     *
     * @param title title of requirement
     * @param why (why) reason of requirement
     * @param who (who) who issued requirement
     * @param what (what) what is the point of requirement
     * @param date deadline of requirement
     */
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
        this.isApproved = false;
        this.isDisapproved = false;
        this.requirementStatus = "not started";
    }

    /**
     * Requirement constructor with 2 parameters
     *
     * @param title title of requirement
     * @param who (who) who issued requirement
     */
    public Requirement(String title, String who){
        this.title = title;
        this.who = who;
    }

    /**
     * remove method for task in task list in requirement
     *
     * @param index index of task to remove from task list
     */
    public void removeTask(int index){
        tasks.remove(index);
    }

    /**
     * get method for spend time on requirement
     * gets the time by sum of all tasks time spent in requirement
     *
     * @return spend time
     */
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

    /**
     * get method for title of requirement
     *
     * @return title of requirement
     */
    public String getTitle() {
        return title;
    }

    /**
     * set method for what (point of requirement)
     *
     * @param what point of requirement
     */
    public void setWhat(String what) {
        this.what = what;
    }

    /**
     * set method for who (who issued requirement)
     *
     * @param who persons name who issued requirement
     */
    public void setWho(String who) {
        this.who = who;
    }

    /**
     * set method for why (reason of requirement)
     *
     * @param why reason of requirement
     */
    public void setWhy(String why) {
        this.why = why;
    }

    /**
     * set method for title of requirement
     *
     * @param title title of requirement
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * sett method for date
     *
     * @param date date
     */
    public void setDate(StartDate_DeadLine date) {
        this.date = date;
    }

    /**
     * set method for estimated time
     * sets estimated time by summing estimated time of tasks inside requirement
     */
    public void setNeededtime() {
        for(int x = 0; x < tasks.size(); x++){
            this.neededtime += tasks.get(x).getTime();
        }
    }

    /**
     * set method for responsible Developer
     *
     * @param developer developer
     */
    public void setResponsibleDeveloper(Developer developer)
    {
        responsibleDeveloper = developer;
    }

    /**
     * add method for adding tasks into requirement
     *
     * @param task task to add
     */
    public void addTask(Task task)
    {
        tasks.add(task);
    }

    /**
     * get method for task
     *
     * @param index index of task
     * @return specific task from list
     */
    public Task getTask(int index)
    {
        return tasks.get(index);
    }

    /**
     * get method for size of task list
     *
     * @return size of task list inside of requirement
     */
    public int getTaskListSize()
    {
        return tasks.size();
    }

    /**
     * get method for responsible Developer
     *
     * @return responsible Developer for Requirement
     */
    public Developer getResponsibleDeveloper() {
        return responsibleDeveloper;
    }

    /**
     * get id method
     *
     * @return id of rquirement
     */
    public String getID() {
        return ID;
    }

    /**
     * get who (person who issued requirement) method
     *
     * @return person name who issued requirement
     */
    public String getWho() {
        return who;
    }

    /**
     * get method for task list
     *
     * @return task list
     */
    public ArrayList<TeamMembers> getList() {
        return list;
    }

    /**
     * get method for what (point of requirement)
     * @return point of requirement
     */
    public String getWhat() {
        return what;
    }

    /**
     * get method for why (reason of requirement)
     * @return reason of requirement
     */
    public String getWhy() {
        return why;
    }

    /**
     * get method for starting date of requirement
     * @return start date
     */
    public String getStartDate()
    {
        return date.getMyDateStartDate().toString();
    }

    /**
     * get method for deadline date of requirement
     * @return deadline date
     */
    public String getDeadLine() {
        return  date.getMyDateDeadline().toString();
    }

    /**
     * get method for estimated time of Requirement
     *
     * @return
     */
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

    /**
     * get method for time spent on requirement
     * getting requirement time by summing time spend from tasks
     * @return time spent
     */
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

    /**
     * get method for if is requirement opened
     * @return boolean if requirement is opened
     */
    public boolean isOpened()
    {
        return isOpened;
    }

    /**
     * set method for if is requirement opened
     * @param opened boolean if requirement is opened
     */
    public void setOpened(boolean opened)
    {
        isOpened = opened;
    }

    /**
     * toString method for requirement
     * @return requirement variables
     */
    public String toString() {
        return " " + ID + " " + why + " " + who + " " + what + " " + responsibleDeveloper + " " + date + " " + neededtime;
    }

    /**
     * set method for approve of requirement
     * @param approved boolean if its approve
     */
    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    /**
     * set method for disapproved of requirement
     * @param disapproved boolean if its disapproved
     */
    public void setDisapproved(boolean disapproved) {
        isDisapproved = disapproved;
    }

    /**
     * get method for approve of requirement
     * @return boolean if requirement is approved
     */
    public boolean getApproved(){
        return isApproved;
    }

    /**
     * get method for status of requirement
     * @return status of requirement
     */
    public String getStatus(){
        return requirementStatus;
    }

    /**
     * set method for requirement
     * sets method by checking if requirement is approved or disapproved
     * and by compering time estimated and time spend
     */
    public void setRequirementStatus(){
        if (isApproved){
            requirementStatus = "finished";
            return;
        }
        if (isDisapproved){
            requirementStatus = "disapproved";
            return;
        }
        if (timeSpent <= 0){
            requirementStatus = "not started";
            return;
        }
        if (timeSpent < neededtime){
            requirementStatus = "in progress";
            return;
        }
        requirementStatus = "to approve";
    }

    /**
     * get method of status of requirement
     * it first sets the status and than returns status
     * @return status of requirement
     */
    public String getRequirementStatus(){
        this.setRequirementStatus();
        return this.getStatus();
    }

    /**
     * remove method for removig all the task from requirement
     */
    public void removeTasks(){
        for(int x = 0; x < tasks.size(); x++){
            tasks.remove(x);
        }
    }

}