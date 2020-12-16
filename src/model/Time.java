package model;

import static java.lang.Double.parseDouble;

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

  public void setHoursEstimated(String time)
  {
    this.hoursEstimated = parseDouble(time);
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

  @Override public String toString()
  {
    return hoursEstimated + "" + hoursSpent;
  }
}