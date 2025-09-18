package com.coder.sanam;

import java.util.*;

public class TaskManager {

    public static void main(String[] args) {
        List<List<Integer>> tasks = Arrays.asList(
                Arrays.asList(1, 101, 10),
                Arrays.asList(2, 102, 20),
                Arrays.asList(3, 103, 15)
        );

        TaskManager taskManager = new TaskManager(tasks);
        taskManager.add(4,104,5);
        taskManager.edit(102,8);
        System.out.println(taskManager.execTop());
        taskManager.rmv(101);
        taskManager.add(5,105,15);
        System.out.println(taskManager.execTop());

        List<List<Integer>> tasksSecond = Arrays.asList(
                Arrays.asList(3, 12, 11),
                Arrays.asList(6, 2, 46),
                Arrays.asList(2, 1, 46),
                Arrays.asList(5, 23, 21)
        );

        TaskManager taskManagerSecond = new TaskManager(tasks);
        System.out.println(taskManagerSecond.execTop());

    }

    private Map<Integer,Integer> taskPriorityMap;
    private Map<Integer,Integer> taskUserMap;
    private PriorityQueue<int[]> pq;

    public TaskManager(List<List<Integer>> tasks) {
        taskPriorityMap = new HashMap<>();
        taskUserMap = new HashMap<>();
        pq = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]){
                return b[0] - a[0]; // Higher priority first
            }else{
                return b[1] - a[1]; // Higher taskId first if priorities are the same
            }
        });

        for(List<Integer> task : tasks){
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            add(userId,taskId,priority);
        }

    }

    public void add(int userId, int taskId, int priority) {
        taskPriorityMap.put(taskId,priority);
        taskUserMap.put(taskId,userId);
        pq.offer(new int[]{priority,taskId});
    }

    public void edit(int taskId, int newPriority) {
        taskPriorityMap.put(taskId,newPriority);
        pq.offer(new int[]{newPriority,taskId});
    }

    public void rmv(int taskId) {
        taskPriorityMap.put(taskId,-1);
    }

    public int execTop() {
        //check if top of priority queue is not stale
        int user = -1;
        while(!pq.isEmpty()) {
            int[] top = pq.peek();
            int highestPriority = top[0];
            int highestPriorityTask = top[1];
            if (taskPriorityMap.get(highestPriorityTask) == highestPriority) {
                user = taskUserMap.get(highestPriorityTask);
                taskPriorityMap.put(highestPriorityTask, -1); // Mark as executed
                break;
            }
            pq.poll();
        }
        return user;


    }
}
