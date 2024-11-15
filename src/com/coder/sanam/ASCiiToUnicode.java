package com.coder.sanam;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ASCiiToUnicode {
	
	public static void main(String[] args) {
        String input = "JÃ©rÃ´me";
        String output = new String(input.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println("Output: " + output);
    }
    
}
