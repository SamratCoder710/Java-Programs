package sanam.stack_queue;

import java.util.Stack;

public class ReverseSubstringBetEachPair {

    static void main() {
        ReverseSubstringBetEachPair reverseSubstringBetEachPair = new ReverseSubstringBetEachPair();
        String res = reverseSubstringBetEachPair.reverseParentheses("(ed(et(oc))el)");
        System.out.println(res);
    }


    public String reverseParentheses(String s) {
        int n = s.length();
        int[] door = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                int j = st.pop();
                door[i] = j;
                door[j] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int dir = 1; // Left-To-Right
        for (int i = 0; i < n; i += dir) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                dir = -dir; // reverse the dir
                i = door[i];
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public String reverseParenthesesBrute(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(sb.length());
            } else if (ch == ')') {
                int start = st.pop();
                int end = sb.length() - 1;
                reverse(sb, start, end);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
