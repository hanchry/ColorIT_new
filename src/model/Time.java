package model;

public class Time
{
  private double hoursEstimated;
  private double hoursSpent;

  public Time(double timeEstimatedInHours)
  {
    this.hoursEstimated = timeEstimatedInHours;
    this.hoursSpent = 0;
  }

  public double getHoursEstimated()
  {
    return hoursEstimated;
  }

  public void setHoursSpent(double hours)
  {
    if (hoursSpent + hours < hoursEstimated)
    {
      hoursSpent += hours;
    }
    else if (hoursSpent + hours > hoursEstimated)
    {
      hours = hoursEstimated - hoursSpent;
      hoursSpent += hours;
    }
  }

  public double getHoursSpent()
  {
    return hoursSpent;
  }

  public String toStringHoursSpent()
  {
    return "" + hoursSpent;
  }

  public String toStringHoursEstimated()
  {
    return "" + hoursEstimated;
  }

  @Override public String toString()
  {
    return hoursEstimated + "" + hoursSpent;
  }
}