package com.coder.sanam.java8.dateAndTime;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class AdvancedDateTime {

    public static void main(String[] args) {

//      Q6. calculate the exact age in years of a person born on 1998-02-15 as of today’s date.

        LocalDate birthDate = LocalDate.of(1998,2,15);
        LocalDate now = LocalDate.now();
        Period between = Period.between(birthDate, now);
        System.out.println(between.getYears());

        // Q7. find the date of the next Monday from today.

        LocalDate localDate = LocalDate.now();
        TemporalAdjuster next = TemporalAdjusters.next(DayOfWeek.MONDAY);
        LocalDate with = localDate.with(next);
        System.out.println(with);


        // Q8. Check If a Given Year Is a Leap Year


//        Arrays.stream(Month.values()).forEach(System.out::println);
        LocalDate date = LocalDate.of(2023,12,1);
        YearMonth febMonth = YearMonth.of(date.getYear(), 2);
        if(febMonth.lengthOfMonth() == 29){
            System.out.println("Leap Year");
        }else{
            System.out.println("Non Leap Year");
        }

        //OR

        String resultString =  date.isLeapYear()?"Leap Year":"Non Leap Year";
        System.out.println(resultString);


    }



}
