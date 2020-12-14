package model;

import java.util.ArrayList;

public class Project {

    private ArrayList<Person> people;
    private ProjectCreator projectCreator;
    private StartDate_DeadLine startDate_deadLine;
    private String title;
    private ArrayList<TeamMembers> teamMembers;
    private boolean isOpened;
    private ArrayList<Requirement> requirements;
    private Time time;

    private boolean finished;


    public Project(String title,StartDate_DeadLine startDeadLine) {
        this.title = title;
        this.requirements = new ArrayList<>();
        teamMembers = new ArrayList<>();
        this.startDate_deadLine = startDeadLine;
        this.isOpened = false;

        this.finished = false;
    }

    public void setFinishProject()
    {
        this.finished = true;
    }

    public boolean isFinishedProject()
    {
        return finished;
    }

  public Project(String title) {
  this.title= title;
  }

  public ProjectCreator getProjectCreator()
    {
        return projectCreator;
    }

    public void removePerson(Person person)
    {
        people.remove(person);
    }

    public void createProject(String title,StartDate_DeadLine startDate_deadLine, ArrayList<TeamMembers> role, ArrayList<Person> people)
    {
        this.title = title;
        this.startDate_deadLine = startDate_deadLine;
        this.teamMembers = role;
        this.people = people;
    }

    public void addPerson(Person person)
    {
      people.add(person);
    }


    public String getHoursEstimated(){
        return time.toStringHoursEstimated();
    }

    public String getHoursSpent(){
        return time.toStringHoursSpent();
    }

    public void addRequriement(Requirement requirement) {
        requirements.add(requirement);
    }

    public StartDate_DeadLine getStart_deadLine() {
        return startDate_deadLine;
    }

    public void setStartDate_deadLine(StartDate_DeadLine deadline)
    {
        this.startDate_deadLine = deadline;
    }

    public TeamMembers getTeamMembers(int index)
    {
        return teamMembers.get(index);
    }

    public String getTitle(){return title;}

    public void setTitle(String title)
    {
        this.title = title;
    }


    public void Edit(String title, Requirement requirement, StartDate_DeadLine startDeadLine) {
        this.title = title;
        this.addRequriement(requirement);
        this.startDate_deadLine = startDeadLine;
    }

    public Requirement getRequirement(String title)
    {
        return null;
    }

    public ArrayList<Requirement> getRequirements(){
        return requirements;
    }

    public Requirement getRequirement(int index)
    {
        return requirements.get(index);
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public String toString() {
        return " "+title+ " " + startDate_deadLine;
    }


}
