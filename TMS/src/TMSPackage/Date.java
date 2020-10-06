/**
 * 
 */
package TMSPackage;

import java.text.DecimalFormat;

/**
 * @author Graham Deubner, Sandeep Alankar
 * This class represents a date, used to record when an account was opened.
 * The format of the date is mm/dd/yyyy.
 * It implements the comparable interface so that date objects may be compared,
 * and an isVald method that decides if the date object contains a possible date.
 *
 */
public class Date implements Comparable<Date>{

    private int year;
    private int month;
    private int day;
    
    /**
     * parameterized constructor method which assigns the year, month, and day to the passed values.
     * @param year
     * @param month
     * @param day
     */
    public Date(int month, int day, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    } 
    
    /**
     *Method which compares this Date object object to the Date Object passed as a parameter.
     *Implements the Comparable interface.
     *@return returns 0 if equivalent, 1 if this Date comes after the passed Date Object, 
     *and -1 if this Date Object comes before the passed Date object.
     */
    public int compareTo(Date date) {//return 0, 1, or -1    when this bigger than param, => 1
        if(date.year == this.year && date.month == this.month && date.day == this.day)
            return 0;
        else if(this.year > date.year || this.month > date.month || this.day > date.day)
            return 1;
        return -1;
    }
    
    /**
     *Method returns the date held by this object in string format: mm/dd/yyyy
     *@return - returns the string literal of the date
     */
    public  String toString() {
        DecimalFormat df2char = new DecimalFormat("00");
        DecimalFormat df4char = new DecimalFormat("00");
        String str = df2char.format(month) + "/" + 
                df2char.format(day) + "/" + df4char.format(year);
        return str;
    }

    /**
     * method checks to see the objects day, month and year can be a real date.
     * @return returns true if the date object contains a real date, false otherwise.
     */
    public boolean isValid() {
        int[] daysInEachMonth = {Month.JAN, Month.FEB, Month.MAR, Month.APR, Month.MAY, 
                Month.JUN, Month.JUL, Month.AUG, Month.SEP, Month.OCT, Month.NOV, Month.DEC};
        if(day < 1 || month < 1 || year < 1)
            return false;
        if(month>daysInEachMonth.length)
            return false;
        if (month == Month.FEBRUARY) {// deals with leap years
            int febDays = Month.FEB;
            if (year % Month.QUADRENNIAL == 0) {
                if (year % Month.CENTENNIAL == 0) {
                    if (year % Month.QUADRACENTENNIAL == 0) {
                        febDays++; //it's a leap year
                    }

                } else {
                    febDays++;// it's a leap year
                }
            }
            if (day > febDays)
                return false;
        } else if (day > daysInEachMonth[month-1])
            return false;
        return true;
    }
    
}
