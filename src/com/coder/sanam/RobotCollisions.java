package com.coder.sanam;

import java.util.*;

public class RobotCollisions {

    public static void main(String[] args) {
         // positions = [3,5,2,6], healths = [10,10,15,12], directions = "RLRL"
        RobotCollisions robotCollisions = new RobotCollisions();
        List<Integer> result = robotCollisions.survivedRobotsHealths(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL");


        // positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = "RRRRR"
        RobotCollisions robotCollisions1 = new RobotCollisions();
        List<Integer> result1 = robotCollisions1.survivedRobotsHealths(new int[]{5, 4, 3, 2, 1}, new int[]{2, 17, 9, 15, 10}, "RRRRR");


        // positions = [1,2,5,6], healths = [10,10,11,11], directions = "RLRL"
        RobotCollisions robotCollisions2 = new RobotCollisions();
        List<Integer> result2 =  robotCollisions2.survivedRobotsHealths(new int[]{1, 2, 5, 6}, new int[]{10, 10, 11, 11}, "RLRL");
        System.out.println(result2);

    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        // Sort robots by position
        Arrays.sort(order, Comparator.comparingInt(a -> positions[a]));

        // Use stack to store indices of right-moving robots
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currIdx : order) {
            if (directions.charAt(currIdx) == 'R') {
                stack.push(currIdx);
            } else {
                // Left-moving robot collides with right-moving robots on stack
                while (!stack.isEmpty() && healths[currIdx] > 0) {
                    int top_idx = stack.peek();
                    stack.poll();

                    if(healths[top_idx] > healths[currIdx]){
                        healths[currIdx] = 0;
                        healths[top_idx]--;
                        stack.push(top_idx);
                    }else if(healths[top_idx] < healths[currIdx]){
                        healths[top_idx] = 0;
                        healths[currIdx]--;
                    }else{
                        healths[top_idx] = 0;
                        healths[currIdx] = 0;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] != 0) {
                res.add(healths[i]);
            }
        }

        return res;
    }
}
