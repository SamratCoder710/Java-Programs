package sanam.math;

public class MinOpsToCorrectTime {
    public static void main(String[] args) {
        MinOpsToCorrectTime solution = new MinOpsToCorrectTime();
        System.out.println(solution.convertTime("02:30", "04:35")); // Output: 3
        System.out.println(solution.convertTime("11:00", "11:01")); // Output: 1
        System.out.println(solution.convertTime("12:00", "12:00")); // Output: 0
    }

    public int convertTime(String current, String correct) {
        int diff = Math.abs(toMinutes(current) - toMinutes(correct));
        int ops = 0;
        ops += diff / 60;
        diff = diff % 60;

        ops += diff / 15;
        diff = diff % 15;

        ops += diff / 5;
        diff = diff % 5;

        ops += diff;

        return ops;
    }

    private int toMinutes(String time){
        int hrs = Integer.parseInt(time.substring(0,2));
        int mins = Integer.parseInt(time.substring(3,5));

        return (hrs * 60) + mins;
    }


}
