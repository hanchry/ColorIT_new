package model;

/**
 * Person class
 */
public class Person {

    private String name;
    private String role;
    private String email;
    private boolean isOpened;

    /**
     * constructor of Person class
     *
     * @param name name of Person
     * @param email email of Person
     * @param role role of Person can be set to ScrumMaster, ProjectCreator, ProjectOwner or Developer
     */
    public Person(String name,String email, String role){
        this.name = name;
        this.email = email;
        this.role = role;
        this.isOpened = false;
    }

    /**
     * setter for isOpened
     *
     * @param isOpened variable (boolean) which sets if person is opened
     */
    public void setOpened(boolean isOpened){
        this.isOpened = isOpened;
    }

    /**
     * isOpened getter
     *
     * @return if person is opened
     */
    public boolean isOpened() {
        return isOpened;
    }

    /**
     * role setter
     *
     * @param role sets specific role of Person
     */
    public void setRole(String role){
        this.role = role;
    }

    /**
     * name getter
     *
     * @return name of person
     */
    public String getName() {
        return name;
    }

    /**
     * email getter
     *
     * @return email of person
     */
    public String getEmail() {
        return email;
    }

    /**
     * role getter
     *
     * @return role of person
     */
    public String getRole() {
        return role;
    }

    /**
     * toString method
     *
     * @return persons info
     */
    public String toString()
    {
        return  name + " " + email + "" + getRole();
    }
}