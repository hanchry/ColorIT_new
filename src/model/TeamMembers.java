package model;

import java.util.ArrayList;

/**
 * TeamMember class
 */
public class TeamMembers {
    private ArrayList<Developer> developers;
    private ArrayList<ProjectOwner> owner;
    private ArrayList<ScrumMaster> scrum;

    /**
     * TeamMembers construct
     */
    public TeamMembers(){
        this.owner = new ArrayList<>();
        this.scrum = new ArrayList<>();

        this.developers = new ArrayList<>();
    }

    /**
     * add method to add Developer to TeamMembers
     * @param person Developer
     */
    public void addDeveloper(Person person){
        developers.add((Developer)person);
    }

    /**
     * add method to add ScrumMaster to TeamMembers
     * @param person ScrumMaster
     */
    public void addScrum(Person person){
        this.scrum.add((ScrumMaster)person);
    }

    /**
     * add method to add ProductOwner to TeamMembers
     * @param person ProductOwner
     */
    public void addOwner(Person person){
        this.owner.add((ProjectOwner) person);
    }

    /**
     * get method for Developer
     * @return Developer
     */
    public ArrayList<Developer> getDevelopers() {
        return developers;
    }

    /**
     * get method for ScrumMaster
     * @return ScrumMaster
     */
    public ArrayList<ScrumMaster> getScrums() {
        return scrum;
    }

    /**
     * get method for ProductOwner
     * @return ProductOwner
     */
    public ArrayList<ProjectOwner> getOwners() {
        return owner;
    }

    /**
     * remove method for ScrumMaster
     * @param index index of ScrumMaster to remove
     */
    public void removeScrum(int index){
        scrum.remove(index);
    }
    /**
     * remove method for ProductOwner
     * @param index index of ProductOwner to remove
     */
    public void removeOwner(int index){
        owner.remove(index);
    }

    /**
     * get method for size of Developer list
     * @return Developer list size
     */
    public int getDevSize(){
        return developers.size();
    }

    /**
     * get method for specific Developer by index
     * @param index index of Developer
     * @return specific Developer
     */
    public Developer getDeveloper(int index){
        return developers.get(index);
    }

    /**
     * get method for specific ProductOwner by index
     * @param index index of ProductOwner
     * @return specific ProductOwner
     */
    public ProjectOwner getOwner(int index) {
        return owner.get(index);
    }

    /**
     * get method for specific ScrumMaster by index
     * @param index index of ScrumMaster
     * @return specific ScrumMaster
     */
    public ScrumMaster getScrum(int index) {
        return scrum.get(index);
    }

    /**
     * remove method for Developer
     * @param index index of Developer to remove
     */
    public void removeDeveloper(int index){
        developers.remove(index);
    }

    /**
     * toString method
     * @return returns all developers
     */
    public String toString()
    {
        String s = " " + owner + " " + scrum + " ";
        for (Developer developer : developers)
        {
            s += developer.toString();
        }
        return null;
    }
}