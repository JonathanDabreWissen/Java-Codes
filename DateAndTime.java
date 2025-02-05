// import java.util.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Set;

import static java.time.Month.*;

public class DateAndTime {
    public static void main(String[] args) {
        /*
        Date d1 = new Date();
        System.out.println(d1);
        d1.setMonth(11);
        System.out.println(d1.getMonth());
        */

    
        LocalDate ld = LocalDate.now();
        System.out.println(ld);


        LocalTime lt = LocalTime.now();
        System.out.println(lt);

        LocalDateTime ltd = LocalDateTime.now();
        System.out.println(ltd);

        System.out.println(ld.withMonth(MARCH.getValue()));

        LocalDate d2 = LocalDate.of(1983, SEPTEMBER, 17);
        System.out.println(d2);

        LocalTime t1 = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(t1);

        Set s = ZoneId.getAvailableZoneIds();
        s.forEach((System.out::println));

        LocalTime t2 = LocalTime.now(ZoneId.of("Asia/Dubai"));
        System.out.println(t1.compareTo(t2));

    }
}
