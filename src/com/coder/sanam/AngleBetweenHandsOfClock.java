package com.coder.sanam;

public class AngleBetweenHandsOfClock {

    public static void main(String[] args) {
        AngleBetweenHandsOfClock angleBetweenHandsOfClock = new AngleBetweenHandsOfClock();
        double v = angleBetweenHandsOfClock.angleClock(12, 30);
        System.out.println(v);
    }

    public double angleClock(int hour, int minutes) {
        double hourHand = (minutes/2.0) + ((hour % 12) * 30 );
        double minuteHand = minutes * 6;
        double ans = Math.abs(hourHand - minuteHand);
        return Math.min(ans , 360.0 - ans);
    }
}
