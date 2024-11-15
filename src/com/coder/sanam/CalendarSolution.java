package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CalendarSolution {

    static class CalendarII {

        class Event{
            int start;
            int end;
            public Event(int start,int end){
                this.start = start;
                this.end = end;
            }
        }
        List<Event> overlapBookings;
        List<Event> bookings;

        public CalendarII() {
            overlapBookings = new ArrayList<>();
            bookings = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for(Event e : overlapBookings){
                if(isOverlap(e,start,end)){
                    return false;
                }
            }

            for(Event e: bookings){
                if(isOverlap(e,start,end)){
                    overlapBookings.add(getOverlapEvent(e,start,end));
                }
            }
            bookings.add(new Event(start,end));
            return true;
        }

        private Event getOverlapEvent(Event e, int start, int end) {
            return new Event(Math.max(e.start,start),Math.min(e.end,end));
        }

        private boolean isOverlap(Event e, int start, int end) {
            return Math.max(e.start,start) < Math.min(e.end,end);
        }


    }

    public static void main(String[] args) {
        CalendarII myCalendarTwo = new CalendarII();
        boolean book = myCalendarTwo.book(10, 20);// return True, The event can be booked.
        boolean book1 = myCalendarTwo.book(50, 60);// return True, The event can be booked.
        boolean book2 = myCalendarTwo.book(10, 40);// return True, The event can be double booked.
        boolean book3 = myCalendarTwo.book(5, 15);// return False, The event cannot be booked, because it would result in a triple booking.
        boolean book4 = myCalendarTwo.book(5, 10);// return True, The event can be booked, as it does not use time 10 which is already double booked.

        boolean book5 = myCalendarTwo.book(25, 55);

        System.out.println(book);
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
        System.out.println(book5);
    }

}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
