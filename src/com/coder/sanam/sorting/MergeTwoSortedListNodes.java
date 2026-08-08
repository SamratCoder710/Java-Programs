package com.coder.sanam.MergeTwoSortedListNodes;


public class MergeTwoSortedListNodes {
	public static SinglyListNode mergeTwoLists(SinglyListNode list1, SinglyListNode list2) {
    	SinglyListNode resultNode = new SinglyListNode();
    	SinglyListNode curr = resultNode;
		while (list1 != null && list2 != null) {
			if (list1.val > list2.val) {
				curr.next = list2;
				list2 = list2.next;
			} else {
				curr.next = list1;
				list1 = list1.next;
			}
			curr = curr.next;
		}
		
		if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }
		
        return resultNode.next;
   }
    
    public static void main(String[] args) {
        // Create input lists
        SinglyListNode list1 = new SinglyListNode(1, new SinglyListNode(2, new SinglyListNode(4)));
        SinglyListNode list2 = new SinglyListNode(1, new SinglyListNode(3, new SinglyListNode(4)));

        // Merge the two lists
        SinglyListNode mergedList = mergeTwoLists(list1, list2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}


