package model;

/**
 * Project Owner class which extends Person
 */
public class ProjectOwner extends Person{
    /**
     * Constructor of ProjectOwner which sets variables of Developer object
     *
     * @param name  name of ProjectOwner
     * @param email email address of ProjectOwner
     * @param role  role of Person which is in this case ProjectOwner can be changed to another role (ScrumMaster, ProjectCreator, ProjectOwner, Developer)
     */
    public ProjectOwner(String name, String email, String role) {
        super(name, email, role);
    }}