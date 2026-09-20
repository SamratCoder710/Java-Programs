package sanam.interviewPrep;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HashTag {

    static void main() {
        String sentence = "hello world java";

        String k =
                Arrays.stream(sentence.split(" "))
                        .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                        .collect(Collectors.joining(""));

        // String.join(delimited,Iterable charSequence)
        String hashTag = "#" + k;
        System.out.println(hashTag);
    }
}
