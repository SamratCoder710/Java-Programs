package sanam.stack_queue;

import java.util.Stack;

public class MaxNestDepthOfParentheses {

    static void main() {
        MaxNestDepthOfParentheses maxNestDepthOfParentheses = new MaxNestDepthOfParentheses();
        int depth = maxNestDepthOfParentheses.maxDepth("(1+(2*3)+((8)/4))+1");
        System.out.println(depth);
    }

    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(ch);
                res = Math.max(res, st.size());
            } else if (ch == ')') {
                st.pop();
            }
        }
        return res;
    }
}
