package com.coder.sanam;


import java.util.*;

class TreeNodeNew {
    int val;
    TreeNodeNew left;
    TreeNodeNew right;
    TreeNodeNew() {}
    TreeNodeNew(int val) { this.val = val; }
    TreeNodeNew(int val, TreeNodeNew left, TreeNodeNew right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



public class MinimumNumberOfOperationsToSortBinaryTree {

    public static void main(String[] args) {
        TreeNodeNew root = new TreeNodeNew(1);
root.left = new TreeNodeNew(4);
root.right = new TreeNodeNew(3);
root.left.left = new TreeNodeNew(7);
root.left.right = new TreeNodeNew(6);
root.right.left = new TreeNodeNew(8);
root.right.right = new TreeNodeNew(5);
root.right.left.left = new TreeNodeNew(9);
root.right.right.left = new TreeNodeNew(10);
        System.out.println(minimumOperations(root));

    }

    public static int minimumOperations(TreeNodeNew root) {
        Queue<TreeNodeNew> que = new LinkedList<>();
        que.add(root);
        int swapCount = 0;

        while(!que.isEmpty()){
            int size = que.size();
            TreeNodeNew curr = que.peek();
            for(int i=0;i<size;i++){
                curr = que.remove();
                if(curr.left!=null) que.add(curr.left);
                if(curr.right!=null) que.add(curr.right);
            }
            int[] arr = new int[que.size()];
            int k = 0;
            for (TreeNodeNew num : que) {
                arr[k++] = num.val;
            }
            swapCount += minSwaps(arr,k);
        }
        return swapCount;

    }



    private static int indexOf(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == ele)
                return i;

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int minSwaps(int[] arr, int N) {
        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, N);
        Arrays.sort(temp);

        for (int i = 0; i < N; i++) {
            if (arr[i] != temp[i]) {
                ans++;
                swap(arr, i, indexOf(arr, temp[i]));
            }
        }
        return ans;
    }

}
