package com.coder.sanam;

import java.util.*;

public class MinJumpsViaPrimeTransportation {

    public static void main(String[] args) {
        MinJumpsViaPrimeTransportation minJumpsViaPrimeTransportation = new MinJumpsViaPrimeTransportation();
        int result = minJumpsViaPrimeTransportation.minJumps(new int[]{10, 20});
        System.out.println(result);
    }


    private boolean[] buildSieve(int lastEle) {
        boolean[] isPrime = new boolean[lastEle + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= lastEle; i++) {
            if (isPrime[i]) {
                for (int mul = i * i; mul <= lastEle; mul += i) {
                    isPrime[mul] = false;
                }
            }
        }

        return isPrime;
    }

    public int minJumps(int[] nums) {

        int n = nums.length;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int maxEle = nums[0];
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            maxEle = Math.max(nums[i], maxEle);
        }

        boolean[] isPrime = buildSieve(maxEle);
        boolean[] visited = new boolean[n];
        int steps = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[0] = true;
        Set<Integer> seen = new HashSet<>();

        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                int eleIdx = que.poll();

                if (eleIdx == n - 1) {
                    return steps;
                }

                if (eleIdx - 1 >= 0 && !visited[eleIdx - 1]) {
                    que.offer(eleIdx - 1);
                    visited[eleIdx - 1] = true;
                }

                if (eleIdx + 1 < n && !visited[eleIdx + 1]) {
                    que.offer(eleIdx + 1);
                    visited[eleIdx + 1] = true;
                }
                int num = nums[eleIdx];
                if (!isPrime[num] || seen.contains(num)) {
                    size--;
                    continue;
                }

                for (int multiple = num; multiple <= maxEle; multiple += num) {
                    if (!mp.containsKey(multiple)) {
                        continue;
                    }

                    for (int idx : mp.get(multiple)) {
                        if (!visited[idx]) {
                            que.offer(idx);
                            visited[idx] = true;
                        }
                    }
                }
                seen.add(num);
                size--;
            }
            steps++;
        }

        return -1;
    }

}
