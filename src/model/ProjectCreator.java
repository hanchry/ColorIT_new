package model;

/**
    * ProjectCreator class which extends Person
 */
public class ProjectCreator extends Person{
    /**
     * Constructor of ProjectCreator which sets variables of ProjectCreator object
     *
     * @param name  name of ProjectCreator
     * @param email email address of ProjectCreator
     * @param role  role of Person which is in this case ProjectCreator can be changed to another role (ScrumMaster, ProjectCreator, ProjectOwner, Developer)
     */
    public ProjectCreator(String name, String email, String role) {
        super(name, email, role);
    }

}
