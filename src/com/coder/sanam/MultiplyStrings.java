package com.coder.sanam;

public class MultiplyStrings {

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String res = multiplyStrings.multiply("123456789","987654321");
        String res2 = multiplyStrings.multiplyWrongAnswerForLarge("123456789","987654321");
        System.out.println(res);
        System.out.println(res2);
    }

    public String multiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();

        int[] res = new int[m+n];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[i+j+1];

                res[i+j] += sum / 10;
                res[i+j+1] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int result : res){
            if(!(sb.isEmpty() && result == 0)){
                sb.append((result));
            }
        }
        return sb.toString();
    }



    public String multiplyWrongAnswerForLarge(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if(n2 > n1){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        long carry = 0;
        long finalResult = 0;
        int outUnit = 1; // zeroes for new rows
        for(int i=num2.length() - 1;i>=0;i--){
            int unit = outUnit;
            long res = 0;
            for(int j=num1.length() - 1;j>=0;j--){
                long a = num1.charAt(j) - '0';
                long b = num2.charAt(i) - '0';
                long product =  a * b;
                product += carry;
                res += (product % 10 )* unit;
                carry = product / 10;
                unit = unit * 10;
            }
            if(carry != 0){
                res += carry * unit;
                carry = 0;
            }
            finalResult += res;
            outUnit = outUnit * 10;
        }

        return String.valueOf(finalResult);
    }
}
