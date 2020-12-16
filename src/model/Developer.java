package model;

/**
 * Developer class which extends Person
 */
public class Developer extends Person {
    /**
     * Constructor of Developer which sets variables of Developer object
     *
     * @param name  name of Developer
     * @param email email address of Developer
     * @param role  role of Person which is in this case Developer can be changed to another role (ScrumMaster, ProjectCreator, ProjectOwner, Developer)
     */
    public Developer(String name, String email, String role) {
        super(name, email, role);
    }
}
