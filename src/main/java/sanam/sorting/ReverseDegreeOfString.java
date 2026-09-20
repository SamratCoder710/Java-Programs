package sanam.sorting;

public class ReverseDegreeOfString {

    static void main() {
        ReverseDegreeOfString reverseDegreeOfString = new ReverseDegreeOfString();
        int res = reverseDegreeOfString.reverseDegree("abc");
        System.out.println(res);
    }

    public int reverseDegree(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int idx = i + 1; // 1-indexed
            int mul = (26 - (s.charAt(i) - 'a')) * idx;
            sum += mul;
        }
        return sum;
    }
}
