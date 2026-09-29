package sanam.stack_queue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BracketPairOfString {

    static void main() {
        BracketPairOfString bracketPairOfString = new BracketPairOfString();
        List<List<String>> map = List.of(List.of("name", "bob"), List.of("age", "two"));
        String res = bracketPairOfString.evaluate("(name)is(age)yearsold",map);
        System.out.println(res);
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> dict = new HashMap<>();
        for (List<String> entry : knowledge) {
            dict.put(entry.get(0), entry.get(1));
        }

        int n = s.length();
        int idx = 0;
        while (idx < n) {
            if (s.charAt(idx) == '(') {
                StringBuilder key = new StringBuilder();
                idx++;
                while (s.charAt(idx) != ')') {
                    key.append(s.charAt(idx));
                    idx++;
                }
                sb.append(dict.getOrDefault(key.toString(), "?"));
                idx++;
            } else {
                sb.append(s.charAt(idx));
                idx++;
            }

        }
        return sb.toString();
    }


}
