package com.coder.sanam.java8.dateAndTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RealWorldProblems {

    public static void main(String[] args) {
//        1. Convert LocalDateTime to Epoch Seconds (UTC)
        LocalDateTime localDateTime = LocalDateTime.of(2000,1,26,6,30,50);
        System.out.println(localDateTime);
        long epochSecond = localDateTime.toEpochSecond(ZoneOffset.UTC);
        System.out.println("EpochSecond::"+epochSecond);

//        2. Calculate Duration Between Two Timestamps
        LocalDateTime start = LocalDateTime.of(2025, 6, 9, 14, 0);
        LocalDateTime end = LocalDateTime.of(2025, 6, 9, 18, 45);

        Duration between = Duration.between(start, end);
        System.out.println(between.toHoursPart() +" hours");
        System.out.println(between.toMinutesPart()+ " minutes");

//        3. Get Start and End of the Day
        LocalDate localDate = LocalDate.of(2020,10,20);
        LocalDateTime localDateTime1 = localDate.atStartOfDay();
        LocalDateTime localDateTime2 = localDateTime1.plusDays(1).minusNanos(1);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

//       4. Convert Date String in One Format to Another
        String dateString = "09-06-2025 18:30";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime parse = LocalDateTime.parse(dateString, dateTimeFormatter);

        DateTimeFormatter newDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a", Locale.ENGLISH);
        String customDateString = parse.format(newDateTimeFormatter);
        System.out.println(customDateString);

//        5. Get First and Last Day of Current Month
        LocalDate customDate = LocalDate.now();
        YearMonth yearMonth = YearMonth.of(customDate.getYear(), customDate.getMonth());
        LocalDate endOfMonth = yearMonth.atEndOfMonth();
        LocalDate startOfMonth = yearMonth.atDay(1);
        System.out.println("startOfMonth:"+startOfMonth + " endOfMonth:: "+ endOfMonth);

//        6. List All Mondays in Current Month
        LocalDate localDate1 = LocalDate.now();

        LocalDate firstDay = localDate1.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDay = localDate1.with(TemporalAdjusters.lastDayOfMonth());

        List<LocalDate> mondays = new ArrayList<>();
        LocalDate monday = firstDay.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));

        while(!monday.isAfter(lastDay)){
            mondays.add(monday);
            monday = monday.plusWeeks(1);
        }

        mondays.forEach(System.out::println);

//        7. Convert Between Time Zones

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        ZonedDateTime zonedDateTime1 = Instant.now().atZone(ZoneOffset.UTC);
        System.out.println(zonedDateTime1);
        ZonedDateTime zonedDateTime2 = Instant.now().atZone(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime2);

//        8. Check if a Date is Weekend
        LocalDate localDate2 = LocalDate.now();
        DayOfWeek dayOfWeek = localDate2.getDayOfWeek();
        boolean isWeekend = (dayOfWeek == DayOfWeek.SATURDAY) ||(dayOfWeek ==  DayOfWeek.SUNDAY);
        System.out.println(isWeekend);

//        9. Calculate Billing Period Difference
        LocalDate localDate3 = LocalDate.now();
        LocalDate  localDate4 = LocalDate.of(2025,11,8);

        long between1 = ChronoUnit.DAYS.between(localDate3, localDate4);
        long between2 = ChronoUnit.MONTHS.between(localDate3, localDate4);
        System.out.println(between1);
        System.out.println(between2);

        Period between3 = Period.between(localDate3, localDate4);
        System.out.println(between3);

//        10. Add Business Days (Skip Weekends)
        LocalDate localDate5 = LocalDate.now();
        int businessDaysToBeAdded = 10;
        while(businessDaysToBeAdded > 0){
            localDate5 = localDate5.plusDays(1);
            if(localDate5.getDayOfWeek() != DayOfWeek.SATURDAY && localDate5.getDayOfWeek() != DayOfWeek.SUNDAY){
                businessDaysToBeAdded--;
            }
        }
        System.out.println(localDate5);
    }


}
