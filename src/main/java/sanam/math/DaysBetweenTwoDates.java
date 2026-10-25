package sanam.math;

public class DaysBetweenTwoDates {

    public static void main(String[] args) {
        DaysBetweenTwoDates solution = new DaysBetweenTwoDates();
        System.out.println(solution.daysBetweenDates("2020-01-15", "2020-01-18")); // Output: 3
        System.out.println(solution.daysBetweenDates("2020-02-28", "2020-03-01")); // Output: 2
        System.out.println(solution.daysBetweenDates("2019-12-31", "2020-01-01")); // Output: 1    
    }

    public int daysBetweenDates(String date1, String date2) {
        int daysBetween = Math.abs(dayNo(date1) - dayNo(date2));
        return daysBetween;
    }

    private int dayNo(String date){
        // count days from 1971
        int[] mp = new int[]{31,28,31,30,31,30,31 ,
        31,30,31,30,31};

        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));

        int days = day;

        for(int i=1971;i<year;i++){
            days += isLeapYear(i) ? 366 : 365;
        }

        for(int i=0;i<month - 1;i++){
            days += mp[i];
        }

        if(isLeapYear(year) && month > 2){
            days++;
        }
        return days;
    }

    private boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}