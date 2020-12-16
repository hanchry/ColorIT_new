package model;

import java.util.ArrayList;

/**
 * RequirementsList class
 */
public class RequirementsList
{
  private ArrayList<Requirement> requirements;

  /**
   * requirementsList constructor
   */
  public RequirementsList()
  {
    requirements = new ArrayList<>();
  }

  /**
   * add method fro adding requirements into list
   * @param requirement
   */
  public void add(Requirement requirement)
  {
    requirements.add(requirement);
  }

  /**
   * get method for getting all the requirements
   * @return requirement list
   */
  public ArrayList<Requirement> getRequirements()
  {
    return requirements;
  }

  /**
   * get method for returning size of requirement list
   * @return size of requirement list
   */
  public int getSize()
  {
    return requirements.size();
  }

}
