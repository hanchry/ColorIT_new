package model;

import java.util.ArrayList;

public class RequirementsList
{
  private ArrayList<Requirement> requirements;

  public RequirementsList()
  {
    requirements = new ArrayList<>();
  }

  public void add(Requirement requirement)
  {
    requirements.add(requirement);
  }

  public ArrayList<Requirement> getRequirements()
  {
    return requirements;
  }
  public int getSize()
  {
    return requirements.size();
  }

}
