import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static void main(String[] args) {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = kthLargestElementInArray.findKthLargest_Alternative(nums, k);
        System.out.println(result); // Output: 5
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pque = new PriorityQueue<>(Comparator.reverseOrder());
        for(int x:nums) {
            pque.offer(x);
        }
        int index = k;
        while(index>1) {
            pque.poll();
            index--;
        }
        if (pque.isEmpty()) {
            throw new NoSuchElementException("PriorityQueue is empty");
        }
        return pque.peek();
    }

    public int findKthLargest_Alternative(int[] nums, int k) {
        PriorityQueue<Integer> pque = new PriorityQueue<>();
        for(int x:nums) {
            pque.offer(-x);
        }
        int index = k;
        while(index>1) {
            pque.poll();
            index--;
        }
        if (pque.isEmpty()) {
            throw new NoSuchElementException("PriorityQueue is empty");
        }
        return -pque.peek();
    }


}
