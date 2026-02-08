package com.coder.sanam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.*;

public class KthLargestPerfectSubtreeSize {

    public static void main(String[] args) {
        KthLargestPerfectSubtreeSize kthLargestPerfectSubtreeSize = new KthLargestPerfectSubtreeSize();
        // Input: root = [5,3,6,5,2,5,7,1,8,null,null,6,8], k = 2
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(8);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);

        int i = kthLargestPerfectSubtreeSize.kthLargestPerfectSubtree(root, 2);
        System.out.println(i);
    }

    static class Pair{
        private boolean key;
        private Integer value;

        public Pair(boolean key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public boolean getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        if (root == null) return -1;

        List<Integer> list = new ArrayList<>();
        makeTree(root, list);

        list.sort(Comparator.reverseOrder());
        System.out.println("List:: " + list);
        return list.size() < k ? -1 : list.get(k - 1);
    }

    private Pair makeTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return new Pair(true, 0);
        }

        Pair l = makeTree(root.left, list);
        Pair r = makeTree(root.right, list);

        if (l.getKey() && r.getKey() && l.getValue().equals(r.getValue())) {
            int s = l.getValue() + r.getValue() + 1;
            list.add(s);
            return new Pair(true, s);
        }

        return new Pair(false, 0);
    }
}
