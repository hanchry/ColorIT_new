package model;

import static java.lang.Double.parseDouble;

/**
 * Time class
 */
public class Time
{
  private double hoursEstimated;
  private double hoursSpent;

  /**
   * Time constructor
   * @param timeEstimatedInHours estimated time
   */
  public Time(double timeEstimatedInHours)
  {
    this.hoursEstimated = timeEstimatedInHours;
    this.hoursSpent = 0;
  }

  /**
   * get method for estimated time
   * @return estimated time
   */
  public double getHoursEstimated()
  {
    return hoursEstimated;
  }

  /**
   * set method for estimated hours
   * @param time estimated hours
   */
  public void setHoursEstimated(String time)
  {
    this.hoursEstimated = parseDouble(time);
  }

  /**
   * set method for time spent
   * @param hours spent time
   */
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

  /**
   * toString method
   * @return time
   */
  @Override public String toString()
  {
    return hoursEstimated + "" + hoursSpent;
  }
}