package com.coder.sanam;


public class AddTwoNumbers {



    public static void main(String[] args) {
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};

        ListNode l1 = createList(arr1);
        ListNode l2 = createList(arr2);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

        printList(result);
    }

    // Helper method to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // Helper method to create list from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int val = carry;
            if(l1 != null){
                val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val += l2.val;
                l2 = l2.next;
            }

            carry = val / 10;
            current.next = new ListNode(val % 10);
            current = current.next;
        }

        return dummy.next;
    }


}
