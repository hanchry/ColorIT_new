package model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;



public class StartDate_DeadLine {

MyDate myDateDeadline;
    java.util.Date date = new java.util.Date();
    public StartDate_DeadLine(Date date,MyDate myDateDeadline)
    {
        this.date = date;
        this.myDateDeadline = myDateDeadline;
    }

    public MyDate getMyDateDeadline() {
        return myDateDeadline;
    }

    public Date getDate() {
        return date;
    }


}
