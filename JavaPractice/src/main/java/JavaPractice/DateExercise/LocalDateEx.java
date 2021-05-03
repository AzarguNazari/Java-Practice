package JavaPractice.DateExercise;

import java.time.LocalDate;

public class LocalDateEx {
    
    public static void main(String[] args) {
        
        LocalDate date1 = LocalDate.now();
        LocalDate.of(2017, 4, 4);
//        plusDays()
//        plusWeeks()
//        plusMonths()
//        plusYears()
//        minusDays()
//        minusWeeks()
//        minusMonths()
//        minusYears()
        LocalDate localDate = LocalDate.of(2015, 12, 31);

        LocalDate localDate1 = localDate.plusYears(3);
        LocalDate localDate2 = localDate.minusYears(3);
    }
    
}
