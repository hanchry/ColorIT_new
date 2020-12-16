package model;

public class ProjectCreator extends Person{
    /**
     * Constructor of Developer which sets variables of Developer object
     *
     * @param name  name of ProjectCreator
     * @param email email address of ProjectCreator
     * @param role  role of Person which is in this case Developer can be changed to another role (ScrumMaster, ProjectCreator, ProjectOwner, Developer)
     */
    public ProjectCreator(String name, String email, String role) {
        super(name, email, role);
    }

}
