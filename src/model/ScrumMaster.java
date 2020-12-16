package model;

/**
 * ScrumMaster class which extends Person
 */
public class ScrumMaster extends Person {
    /**
     * Constructor of ScrumMaster which sets variables of ScrumMaster object
     *
     * @param name  name of ScrumMaster
     * @param email email address of ScrumMaster
     * @param role  role of Person which is in this case ScrumMaster can be changed to another role (ScrumMaster, ProjectCreator, ProjectOwner, Developer)
     */
    public ScrumMaster(String name, String email, String role){
        super(name, email, role);
    }
}
