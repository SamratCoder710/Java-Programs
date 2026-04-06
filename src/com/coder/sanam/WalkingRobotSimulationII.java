package com.coder.sanam;

import java.util.Arrays;

// Original step-by-step simulation
class Robot {
    private int x;
    private int y;
    private int row;
    private int col;
    private int dirIdx;
    private int[][] directions;

    public Robot(int width, int height) {
        row = width;
        col = height;
        directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        dirIdx = 1;
    }

    public void step(int num) {
        while(num > 0){
            int nx = x + directions[dirIdx][0];
            int ny = y + directions[dirIdx][1];
            if(nx < 0 || nx >= row || ny < 0 || ny >= col){
                dirIdx = (dirIdx - 1 + 4) % 4;
                continue;
            }
            x = nx;
            y = ny;
            num--;
        }
    }

    public int[] getPos() {
        return new int[]{x,y};
    }

    public String getDir() {
        return switch (dirIdx) {
            case 0 -> "North";
            case 1 -> "East";
            case 2 -> "South";
            case 3 -> "West";
            default -> "";
        };
    }
}



public class WalkingRobotSimulationII {
    public static void main(String[] args) {
        // Demo with the optimized robot
        Robot robot = new Robot(6,3);
        robot.step(2);
        robot.step(2);
        int[] pos1 = robot.getPos();
        System.out.println("Optimized: " + Arrays.toString(pos1));
        String dir1 = robot.getDir();
        System.out.println("Optimized: " + dir1);
        robot.step(2);
        robot.step(1);
        robot.step(4);
        int[] pos2 = robot.getPos();
        System.out.println("Optimized: " + Arrays.toString(pos2));
        String dir2 = robot.getDir();
        System.out.println("Optimized: " + dir2);

        // Uncomment below to test the original robot
        // Robot robot2 = new Robot(6,3);
        // robot2.step(2);
        // robot2.step(2);
        // int[] pos3 = robot2.getPos();
        // System.out.println("Original: " + Arrays.toString(pos3));
        // String dir3 = robot2.getDir();
        // System.out.println("Original: " + dir3);
        // robot2.step(2);
        // robot2.step(1);
        // robot2.step(4);
        // int[] pos4 = robot2.getPos();
        // System.out.println("Original: " + Arrays.toString(pos4));
        // String dir4 = robot2.getDir();
        // System.out.println("Original: " + dir4);
    }

}
