package com.coder.sanam;

import java.util.Arrays;
import java.util.Stack;

import static java.lang.Math.abs;

public class AsteroidCollisionsLeetcode {

    public static void main(String[] args) {
        AsteroidCollisionsLeetcode asteroidCollisionsLeetcode = new AsteroidCollisionsLeetcode();
//        int [] result = asteroidCollisionsLeetcode.asteroidCollision(new int[]{8, -8});

        //[5,10,-5]
        int [] result2 = asteroidCollisionsLeetcode.asteroidCollision(new int[]{3,5,-6,2,-1,4});
        System.out.println(Arrays.toString(result2));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int currAsteroid : asteroids){
            while(!stack.isEmpty() && stack.peek() > 0 && currAsteroid < 0){
                if(stack.peek() > Math.abs(currAsteroid)){
                    currAsteroid = 0;
                    break;
                }else if(stack.peek() == Math.abs(currAsteroid)) {
                    stack.pop();
                    currAsteroid = 0;
                    break;
                }
                else if(stack.peek() < Math.abs(currAsteroid)){
                    stack.pop();
                }
            }
            if(currAsteroid != 0){
                stack.push(currAsteroid);
            }

        }

        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
