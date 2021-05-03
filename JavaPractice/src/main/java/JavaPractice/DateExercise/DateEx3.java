package JavaPractice.DateExercise;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx3 {
    
    public static void main(String[] args) {
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(new Date(System.currentTimeMillis())));
        
//        yyyy-MM-dd           (2009-12-31)
//
//        dd-MM-YYYY           (31-12-2009)
//
//        yyyy-MM-dd HH:mm:ss  (2009-12-31 23:59:59)
//
//        HH:mm:ss.SSS         (23:59.59.999)
//
//        yyyy-MM-dd HH:mm:ss.SSS   (2009-12-31 23:59:59.999)
//
//        yyyy-MM-dd HH:mm:ss.SSS Z   (2009-12-31 23:59:59.999 +0100)   

//            y   = year   (yy or yyyy)
//            M   = month  (MM)
//            d   = day in month (dd)
//            h   = hour (0-12)  (hh)
//            H   = hour (0-23)  (HH)
//            m   = minute in hour (mm)
//            s   = seconds (ss)
//            S   = milliseconds (SSS)
//            z   = time zone  text        (e.g. Pacific Standard Time...)
//            Z   = time zone, time offset (e.g. -0800)
        
    }
    
}
