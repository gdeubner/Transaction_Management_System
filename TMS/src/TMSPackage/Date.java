/**
 * 
 */
package TMSPackage;

import java.text.DecimalFormat;

/**
 * @author gdeub
 *
 */
public class Date implements Comparable<Date>{

    private int year;
    private int month;
    private int day;
    
    public int compareTo(Date date) {//return 0, 1, or -1    when this bigger than param, => 1
        if(date.year == this.year && date.month == this.month && date.day == this.day)
            return 0;
        else if(this.year > date.year || this.month > date.month || this.day > date.day)
            return 1;
        return -1;
    }
    
    public  String toString() {//in the format mm/dd/yyyy
        DecimalFormat df2char = new DecimalFormat("##");
        DecimalFormat df4char = new DecimalFormat("##");
        String str = df2char.format(month) + "/" + 
                df2char.format(day) + "/" + df4char.format(year);
        System.out.println(str);
        return str;
    }
    
    public boolean isValid() {
        
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if(day < 1 || month < 1 || year < 1)
            return false;
        if(month>months.length)
            return false;
        if(day>months[month])
            return false;
        return true;
    }
    
    public static void main(String[] args) {
        int day = 29;
        int month = 07;
        int year = 1997;
        DecimalFormat df2char = new DecimalFormat("00");
        DecimalFormat df4char = new DecimalFormat("00");
        String str = df2char.format(month) + "/" + 
                df2char.format(day) + "/" + df4char.format(year);
        System.out.println(str);
    }
    
}
