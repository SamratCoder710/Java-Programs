package com.coder.sanam;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public static void main(String[] args) {
        JumpGameIII jumpGameIII = new JumpGameIII();
        boolean result = jumpGameIII.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5);
        System.out.println(result);
    }


    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                int idx = que.poll();
                if (arr[idx] == 0) {
                    return true;
                }

                int posJump = idx + arr[idx];
                if (posJump < n && !visited[posJump]) {
                    que.offer(posJump);
                    visited[posJump] = true;
                }

                int negJump = idx - arr[idx];
                if (negJump >= 0 && !visited[negJump]) {
                    que.offer(negJump);
                    visited[negJump] = true;
                }

                size--;
            }
        }
        return false;
    }

}
