package sanam.math;

public class CountDaysSpentTogether {
    public static void main(String[] args) {
        CountDaysSpentTogether solution = new CountDaysSpentTogether();
        System.out.println(solution.countDaysTogether("08-15", "08-18", "08-16", "08-19")); // Output: 3
        System.out.println(solution.countDaysTogether("10-01", "10-31", "11-01", "12-31")); // Output: 0
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int daysSpentTogether  =  Math.min(dayNo(leaveAlice),dayNo(leaveBob)) - Math.max(dayNo(arriveAlice), dayNo(arriveBob)) + 1;


        return daysSpentTogether <  0 ? 0 : daysSpentTogether; 
    }

    private int dayNo(String date){
         int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int dayNo = day;

        for (int i = 0; i < month - 1; i++) {
            dayNo += daysInMonth[i];
        }

        return dayNo;
    }   





}
