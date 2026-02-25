package com.coder.sanam;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {


    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        int [] res = asteroidCollision.asteroidCollision(new int[]{8,-8});
        System.out.println(Arrays.toString(res));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids){
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek() > 0 && asteroid < 0){
                if(st.peek() == Math.abs(asteroid)){
                    st.pop();
                    destroyed = true;
                    break;
                }else if(st.peek() > Math.abs(asteroid)){
                    destroyed = true;
                    break;
                }else if(st.peek() < Math.abs(asteroid)){
                    st.pop();
                }
            }
            if(!destroyed){
                st.push(asteroid);
            }
        }

        int[] result = new int[st.size()];
        int idx = st.size() - 1;
        while(!st.isEmpty()){
            result[idx] = st.pop();
            idx--;
        }

        return result;
    }
}
