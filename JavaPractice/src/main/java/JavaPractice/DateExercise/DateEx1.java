package JavaPractice.DateExercise;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateEx1 {
    
    
    public static void main(String[] args) {
        
        Date date = new Date(System.currentTimeMillis());
        
        System.out.println("Date : " + date);
        System.out.println("Year : " + date.getYear());
        System.out.println("Day : " + date.getDay());
        System.out.println("Minute: " + date.getMinutes());
        System.out.println("Month : " + date.getMonth());
        System.out.println("Current Time : " + date.getTime());
        
        Date date2 = new Date(2015, 5, 5);
        System.out.println(date.after(date2));
        
        Date date3 = new Date(2019, 2, 2);
        System.out.println(date.before(date));
        
        Date dateTemp = (Date) date.clone();
       
        
    }
    
}
