
package JavaPractice.DateExercise;

import java.time.LocalTime;

public class LocalTimeEx {
    
    public static void main(String[] args) {
        
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        
//        plusHours()
//        plusMinutes()
//        plusSeconds()
//        plusNanos()
//        minusHours()
//        minusMinutes()
//        minusSeconds()
//        minusNanos()
            LocalTime localTime2 = LocalTime.of(21, 30, 59, 11001);

LocalTime localTimeLater   = localTime.plusHours(3);
LocalTime localTimeEarlier = localTime.minusHours(3);
        }
    
}
