package model;


import javafx.scene.chart.PieChart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StartDate_DeadLine {

    private MyDate myDateDeadline;
    private MyDate myDateStartDate;
    private DateFormat dateFormat;
    private Date date;
    private String[] datesValues;

    public StartDate_DeadLine(MyDate myDateDeadline)
    {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = new Date();
        datesValues = new String[3];
        datesValues = dateFormat.format(date).split("/");
        this.myDateStartDate = new MyDate(Integer.parseInt(datesValues[0]),Integer.parseInt(datesValues[1]),Integer.parseInt(datesValues[2]));
        this.myDateDeadline = myDateDeadline;
    }

    public MyDate getMyDateDeadline() {
        return myDateDeadline;
    }

    public MyDate getMyDateStartDate() {
        return myDateStartDate;
    }
}
