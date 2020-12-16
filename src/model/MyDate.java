package model;

/**
 * Class MyDate which setts date
 */

public class MyDate {
    int day;
    int month;
    int year;

    /**
     * Constructor of MyDate which sets variables of MyDate
     *
     * @param day  specific day of MyDate
     * @param month specific month of MyDate
     * @param year specific year of MyDate
     */

    public MyDate(int day, int month, int year) {
        set(day, month, year);
    }

    /**
     * Constructor of MyDate witch dosent sets variables of MyDate class
     */
    public MyDate() {

    }

    /**
     * setter of MyDate class which sets variables of MyDate
     * it checks if the input is realistic if its not it sets variable/s to closest realistic one
     *
     * @param day  day of date if day variable is less then 0 it set into 1 or if its more than number of days in month it set into last day in month
     * @param month month of date if month variable is less then 1 its set to 1 if its more than 12 its set to 12
     * @param year year of date if year variable is less then 0 its set into positive value
     */
    public void set(int day, int month, int year) {
        if (year < 0) {
            this.year = -year;
        } else {
            this.year = year;
        }
        if (month < 1) {
            this.month = 1;
        } else if (month > 12) {
            this.month = 12;
        } else {
            this.month = month;
        }

        this.day = day;
        if (this.day < 0) {
            this.day = 1;
        } else if (this.day > numberOfDaysInMonth()) {
            this.day = numberOfDaysInMonth();
        }
    }

    /**
     * day getter
     *
     * @return returns day variable
     */
    public int getDay() {
        return day;
    }

    /**
     * month getter
     *
     * @return returns month
     */
    public int getMonth() {
        return month;
    }

    /**
     * year getter
     *
     * @return returns year
     */
    public int getYear() {
        return year;
    }

    /**
     * toString method
     *
     * @return returns whole Date
     */
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    /**
     * isLeapYear method
     *
     * @return returns if the year is leap year
     */
    public boolean isLeapYear() {
        if (year % 4 == 0 && (!(year % 100 == 0) || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * numberOfDaysInMonth method
     *
     * @return returns how many days is in specific month
     */
    public int numberOfDaysInMonth() {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                if (isLeapYear()) {
                    return 29;
                } else {
                    return 30;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return -1;
        }
    }

    /**
     * getMonthName method
     *
     * @return returns name of month by checking month number and the value assigned to him
     */
    public String getMonthName() {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "";
        }
    }

    /**
     * equals method
     *
     * @param other made new MyDate which is later on compared
     * @return returns boolean if given (MyDate other) object is equal to MyDate object
     */
    public boolean equals(MyDate other) {
        if (year == other.year && month == other.month && day == other.day) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * getDate method
     *
     * @return returns whole Date
     */
    public String getDate(){
        return day + "." + month + "." + year;
    }



}