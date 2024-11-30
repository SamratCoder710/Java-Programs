package com.coder.sanam;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Runner1 extends Thread {
//    public void execute(){
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Runner1: "+i);
//        }
//    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner1: ");
        }
    }
}

class Runner2 implements Runnable{
//    public void execute(){
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Runner2: "+i);
//        }
//    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner2: "+i);
        }
    }
}



public class Worker {

    private static int counter = 0;

    static{
        System.out.println("Static block");
    }

    {
        System.out.println("Instance Block");
    }


    public static void main(String[] args) throws InterruptedException {
//        process();
        System.out.println("Main method");
        Worker worker = new Worker();

        Map<Integer,Integer> mp = new ConcurrentHashMap<>();
        mp.put(1,10);
        mp.put(null,13);
        mp.put(3,null);
        mp.put(5,null);

        System.out.println(mp);

    }

    private static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    incrementCounter();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    incrementCounter();
                }
            }
        });



        t1.start();
        t2.start();

        Object obj = new Object();

        t1.join();
        t2.join();
        System.out.println("Last line of process .."+Thread.currentThread().getName() + ":Counter::"+counter);
    }

    private static synchronized void incrementCounter() {
        counter++;
    }
}
