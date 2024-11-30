package com.coder.sanam;

interface I1{
    default void print(){
        System.out.println("i1 print");
    }
}

interface I2{
    default void print(){
        System.out.println("i2 print");
    }
}

class DemoTutorial implements I1,I2{
    @Override
    public void print() {
        I1.super.print();
    }
}


public class DefaultMethodTutorial {
    public static void main(String[] args) {
        DemoTutorial demoTutorial = new DemoTutorial();
        demoTutorial.print();
    }
}
