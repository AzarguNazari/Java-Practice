package JavaPractice.DateExercise;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalUnit;

public class DurationEx1 {

    public static void main(String[] args) {

        Instant first = Instant.now();

        for (int x = 0; x < 10000000; x++) {
            String s = "Ahmad";
        }
        
        Instant second = Instant.now();

        Duration duration = Duration.between(first, second);
        duration.getNano();
        duration.getSeconds();
        duration.toMinutes();
        duration.toDays();
        duration.toHours();
        duration.toMillis();
        duration.plusHours(12);
        duration.minusHours(6);
       
    }

}
