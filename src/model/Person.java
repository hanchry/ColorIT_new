package model;


public class Person {
    private String phoneNumber;
    private String name;
    private String role;
    private String id;

    public Person(String name,String id){
        this.name = name;
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }

    // Adding toString to test!

    public String toString()
    {
        return phoneNumber + "" + name + " " + id + "" + getRole();
    }
}