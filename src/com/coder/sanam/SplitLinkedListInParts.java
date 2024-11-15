package com.coder.sanam;

import java.util.Arrays;

public class SplitLinkedListInParts {

    public static void main(String[] args) {
        ListNode input = new ListNode(1,new ListNode(2,new ListNode(3)));

        System.out.println(Arrays.toString(splitListToParts(input, 5)));
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int L = 0;
        while (curr != null) {
            L++;
            curr = curr.next;
        }
        int eachBucketNodes = L / k;
        int remainderNodes = L % k;
        ListNode[] result = new ListNode[k];
        curr = head;
        ListNode prev = null;
        for (int i = 0; curr != null && i < k; i++) {
            result[i] = curr;
            for (int count = 1; count <= eachBucketNodes + (remainderNodes > 0 ? 1 : 0); count++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null)prev.next = null;
            remainderNodes--;
        }

        return result;
    }
}
