package model;


import javafx.scene.chart.PieChart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * StartDate_DeadLine class
 */
public class StartDate_DeadLine {

    private MyDate myDateDeadline;
    private MyDate myDateStartDate;
    private transient DateFormat dateFormat;
    private Date date;
    private String[] datesValues;

    /**
     * StartDate_DeadLine constructor
     * @param myDateDeadline deadline
     */
    public StartDate_DeadLine(MyDate myDateDeadline)
    {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = new Date();
        datesValues = new String[3];
        datesValues = dateFormat.format(date).split("/");
        this.myDateStartDate = new MyDate(Integer.parseInt(datesValues[0]),Integer.parseInt(datesValues[1]),Integer.parseInt(datesValues[2]));
        this.myDateDeadline = myDateDeadline;
    }

    /**
     * get method for deadline
     * @return deadline
     */
    public MyDate getMyDateDeadline() {
        return myDateDeadline;
    }

    /**
     * get method for start date
     * @return start date
     */
    public MyDate getMyDateStartDate() {
        return myDateStartDate;
    }
}
