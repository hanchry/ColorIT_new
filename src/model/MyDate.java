package model;

public class MyDate {
    int day;
    int month;
    int year;

    public MyDate(int day, int month, int year) {
        set(day, month, year);
    }

    public MyDate() {

    }

    public void set(int day, int month, int year) {
        if (year < 0) {
            this.year = -year;
        } else {
            this.year = year;
        }
        // or short:
        // this.year = Math.abs(year):
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

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public boolean isLeapYear() {
        if (year % 4 == 0 && (!(year % 100 == 0) || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
        // or for short:
        // return year%4 == 0 && (!(year%100 == 0) || year%400 == 0)
    }
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


    public boolean isBefore(MyDate date2) {
        if (year < date2.getYear()) {
            return true;
        } else if (year == date2.getYear() && month < date2.getMonth()) {
            return true;
        } else if (year == date2.getYear() && month == date2.getMonth() && day <= date2.getDay()) {
            return true;
        } else {
            return false;
        }
    }



    public MyDate copy() {
        MyDate resultat = new MyDate();
        resultat.set(this.day, this.month, this.year);
        return resultat;
    }

    public boolean equals(MyDate other) {
        if (year == other.year && month == other.month && day == other.day) {
            return true;
        } else {
            return false;
        }

        // eller return year == other.year && month = other.month && day == other.day
    }

    public String getDate(){
        return day + "." + month + "." + year;
    }



}