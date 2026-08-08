package com.coder.sanam.java8.dateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateTimeBasics {

    public static void main(String[] args) {

//        Q1. Write the code to:
//
//        Print the current date (e.g., 2025-06-09)
//
//        Print the current time (e.g., 18:15:00)
//
//        Print the current date and time together

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //Q2. How do you parse the following date string "2025-12-01" into a LocalDate?

        LocalDate parsedLocalDate = LocalDate.parse("2025-12-01");
        System.out.println(parsedLocalDate);

        //Q3. How do you add 2 weeks and 3 days to the current date using LocalDate?

        LocalDate now = LocalDate.now();
        LocalDate customDate = now.plusWeeks(2).plusDays(3);
        System.out.println(customDate);


        //Q4. How do you find the number of days between two dates in Java 8?

        LocalDate start = LocalDate.of(2025, 6, 9);
        LocalDate end = LocalDate.of(2025, 7, 15);

        Period between = Period.between(start, end);
        System.out.println(between);

        System.out.println(between.get(ChronoUnit.DAYS));
        long between1 = ChronoUnit.DAYS.between(start, end);
        System.out.println(between1);

        //Q5. How do you format a LocalDateTime like 2025-06-09T18:30:00 into the string:
        //"09 Jun 2025, 06:30 PM"?

        LocalDateTime localDateTime1 = LocalDateTime.of(2025, 6, 9, 18, 30);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a", Locale.ENGLISH);
        String dateString = localDateTime1.format(dateTimeFormatter);
        System.out.println(localDateTime1);
        System.out.println(dateString);


    }
}
