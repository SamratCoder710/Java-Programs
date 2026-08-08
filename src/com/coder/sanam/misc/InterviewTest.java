package com.coder.sanam.misc;

public class InterviewTest {
    private static int counter = 0;

    public InterviewTest() {

    }

    void InterviewTest() {
        counter = 20;
    }
    InterviewTest(int x){
        counter = x;
    }
    public static void main(String[] args) {
        InterviewTest interviewbitTest = new InterviewTest();
        System.out.println(counter);
    }
}
