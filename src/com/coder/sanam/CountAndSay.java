package com.coder.sanam;

public class CountAndSay {
	
	public static String countAndSay(int n) {
		String s = "1";
		for (int i = 2; i <= n; i++) {
			s = say(s);
		}
		return s;

	}
	 
	private static String say(String s) {
		StringBuilder result = new StringBuilder();;
		int left = 0;
		while (left < s.length()) {
			int counter = 0;
			char temp = s.charAt(left);
			while (left < s.length() && temp == s.charAt(left)) {
				left += 1;
				counter += 1;

			}
			result.append(counter).append(temp);
		}

		return result.toString();
	}

	public static void main(String[] args) {
		String countAndSay = countAndSay(6);
		System.out.println(countAndSay);
	}

}
