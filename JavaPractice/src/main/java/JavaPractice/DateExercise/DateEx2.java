
package JavaPractice.DateExercise;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateEx2 {
    
    public static void main(String[] args) {
        
        Calendar calender = new GregorianCalendar(2015, 2, 2); // First type of calender
        
        Calendar calender2 = new GregorianCalendar(Locale.US);
        System.out.println(calender2.get(Calendar.YEAR));

        System.out.println(calender.after(new Date(2015,5,2)));  // check whether its before or not
        calender.after(new Date(System.currentTimeMillis()));
        calender.clear();
        calender.clear(Calendar.MONTH);
        calender.compareTo(new GregorianCalendar());
        calender.equals(new Date(2012, 2, 2));
        calender.getCalendarType(); // get the type of calender
        calender.getActualMaximum(Calendar.MINUTE);
        calender.getMinimum(Calendar.DAY_OF_WEEK);
        calender.set(2019, 2, 2, 3, 2, 0);
   
        
        
    }
    
}
