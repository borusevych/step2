package lesson13;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class JavaTimeDemo {

  public static void main(String[] args) {
    LocalDate localDate = LocalDate.now();
    LocalTime localTime = LocalTime.now();

    LocalDateTime ldt = LocalDateTime.now();
    LocalDateTime ldt1 = localTime.atDate(localDate);
    LocalDateTime ldt2 = localDate.atTime(localTime);
    LocalDateTime ldt3 = LocalDateTime.parse("2024-11-30T15:35");
    boolean after = ldt3.isAfter(ldt2);
    boolean before = ldt3.isBefore(ldt2);
    ldt.format(DateTimeFormatter.ISO_DATE_TIME);
    int minute = localTime.getMinute();
    int hour = localTime.getHour();
    int second = localTime.getSecond();
    LocalTime localTime1 = localTime.plusHours(2);
    LocalTime localTime2 = localTime.minusMinutes(10);
    LocalTime localTime3 = localTime.plus(10, ChronoUnit.MILLIS);

    Instant now = Instant.now();
    // 1.01.1970
    long epochSecond = now.getEpochSecond();

    LocalDateTime ldt11 = LocalDateTime.ofInstant(now, ZoneOffset.ofHours(2));
    LocalDateTime ldt12 = LocalDateTime.ofInstant(now, ZoneOffset.ofHours(3));

    System.out.println(ldt11);
    System.out.println(ldt12);
  }

}
