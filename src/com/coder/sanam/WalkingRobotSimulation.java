package com.coder.sanam;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {

    public static void main(String[] args) {
        WalkingRobotSimulation walkingRobotSimulation = new WalkingRobotSimulation();
        int i = walkingRobotSimulation.robotSim(new int[]{4, -1, 3}, new int[][]{});
        System.out.println(i);
    }


    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> blocked = new HashSet<>();
        for (int[] arr : obstacles) {
            blocked.add(arr[0] + "," + arr[1]);
        }
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIdx = 0; // north initially
        int x = 0, y = 0;
        int maxDist = 0;
        for (int cmd : commands) {
            if (cmd == -1) {
                dirIdx = (dirIdx + 1) % 4;
            } else if (cmd == -2) {
                dirIdx = (dirIdx - 1 + 4) % 4;
            } else {
                while (cmd > 0) {
                    int nx = x + directions[dirIdx][0];
                    int ny = y + directions[dirIdx][1];

                    if (blocked.contains(nx + "," + ny)) {
                        break;
                    }

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, (x * x + y * y));
                    cmd--;
                }
            }
        }

        return maxDist;
    }

}
