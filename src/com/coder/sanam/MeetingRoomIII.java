package com.coder.sanam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomIII {

    public static void main(String[] args) {
        MeetingRoomIII obj = new MeetingRoomIII();
        // [1,20],[2,10],[3,5],[4,9],[6,8]
        int [][] meetings = { {1,20},{2,10},{3,5},{4,9},{6,8} };
        int n = 3;
        System.out.println(obj.mostBooked(n, meetings));
    }

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        // store [endTime as long, roomIndex as long] to avoid overflow
        PriorityQueue<long[]> ongoingMeetings = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0]) return Long.compare(a[0], b[0]);
                    return Long.compare(a[1], b[1]);
                }
        );

        int[] roomUsageCount = new int[n];

        for(int[] meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];
            long duration = (long) end - start;

            // Free all rooms that finished by or before this meeting's start
            while (!ongoingMeetings.isEmpty() && ongoingMeetings.peek()[0] <= start) {
                long[] freed = ongoingMeetings.poll();
                availableRooms.offer((int)freed[1]);
            }

            if(!availableRooms.isEmpty()){
                int roomNumber = availableRooms.poll();
                ongoingMeetings.offer(new long[]{ (long) end,roomNumber});
                roomUsageCount[roomNumber]++;
            }else if(!ongoingMeetings.isEmpty()){
                long[] earliest = ongoingMeetings.poll();
                long newEnd =  earliest[0] + duration;
                int roomNumber = (int) earliest[1];
                ongoingMeetings.offer(new long[]{ newEnd,roomNumber});
                roomUsageCount[roomNumber]++;
            }

        }

        int max = -1;
        int roomIdx = -1;
        for(int i=0;i<roomUsageCount.length;i++){
            int ele = roomUsageCount[i];
            if(ele > max){
                max = ele;
                roomIdx = i;
            }
        }

        return roomIdx;

    }
}
