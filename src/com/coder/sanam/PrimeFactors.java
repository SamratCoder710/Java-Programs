package com.coder.sanam;

import java.util.Scanner;

public class PrimeFactors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for(int i=2;i<input;i++){
            while(input %i == 0){
                System.out.println(i);
                input = input/i;
            }
        }
        System.out.println("sanam"+input);
        if(input>2){
            System.out.println(input);
        }

    }
}
