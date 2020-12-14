package model;


public class Person {
    private String name;
    private String role;
    private String email;
    private boolean isOpened;


    public Person(String name,String email, String role){
        this.name = name;
        this.email = email;
        this.role = role;
        this.isOpened = false;
    }

    public void setOpened(boolean isOpened){
        this.isOpened = isOpened;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setRole(String role){
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }



    public String getRole() {
        return role;
    }


    public String toString()
    {
        return  name + " " + email + "" + getRole();
    }
}