package com.coder.sanam;

public class CheckBalancedTree {

        public boolean isBalanced(String num) {
            int sum = 0;
            boolean isEven = true;
            for(int i=0;i<num.length();i++){
                int number = num.charAt(i) - '0';
                if(isEven){
                    sum += number;
                }else{
                    sum -= number;
                }
                isEven = !isEven;
            }
            return sum == 0;
        }

    public static void main(String[] args) {
        CheckBalancedTree checkBalancedTree = new CheckBalancedTree();
        boolean balanced = checkBalancedTree.isBalanced("1232");
        System.out.println(balanced);
    }
}
