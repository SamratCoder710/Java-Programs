package sanam.stack_queue;

import java.util.Arrays;

public class MaxNestDepthOfTwoValidParentheses {

    static void main() {
        MaxNestDepthOfTwoValidParentheses maxNest = new MaxNestDepthOfTwoValidParentheses();
        int [] res = maxNest.maxDepthAfterSplit("()(())()");
        System.out.println(Arrays.toString(res));
    }

    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int depth = 0;
        for (int i = 0; i < n; i++) {
            char ch = seq.charAt(i);
            if (ch == '(') {
                res[i] = depth % 2;
                depth++;
            } else {
                depth--;
                res[i] = depth % 2;
            }
        }
        return res;
    }
}
