package sanam.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingElements {


    static void main() {
        FindMissingElements findMissingElements = new FindMissingElements();
        List<Integer> result = findMissingElements.findMissingElementsOptimal(new int[]{1, 2, 4, 6, 7, 9});
        System.out.println(result);
    }

    public List<Integer> findMissingElementsOptimal(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }
        int idx = 0;
        while (freq[idx] == 0) {
            idx++;
        }
        int min = idx;
        idx = 100;
        while (freq[idx] == 0) {
            idx--;
        }
        int max = idx;
        List<Integer> result = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (freq[i] == 0) {
                result.add(i);
            }
        }
        return result;

    }

    public List<Integer> findMissingElements(int[] nums) {
        int min = 200;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            set.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;

    }
}
