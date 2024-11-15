package com.coder.sanam;

public class IntegerToEnglishWords {

    public static void main(String[] args) {
        String res = numberToWords(1000000);
        System.out.println(res);
    }

    public static String numberToWords(int num) {
        return solve(num);
    }

    private static String solve(int num) {
        String[] belowTen = new String[]{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        String[] belowTeen = new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty"};
        String[] belowHundred = new String[]{"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety","Hundred"};


        if(num == 0) return "Zero";

        if(num < 10) return belowTen[num];

        if(num < 20) return belowTeen[num%10];

        if(num < 100 ) return belowHundred[num/10]+ (num % 10 == 0 ? "" : " "+belowTen[num%10]) ;

        if(num < 1000) return belowTen[num/100] + " Hundred" + (num% 100 == 0 ? "" : " "+ solve(num%100));

        if(num < 1000000) return solve(num/1000) + " Thousand" + (num% 1000 == 0 ? "" : " "+ solve(num%1000));

        if(num < 1000000000) return solve(num/1000000) + " Million" + (num% 1000000 == 0 ? "" : " "+ solve(num%1000000));

        return solve(num/1000000000)+ " Billion" + (num% 1000000000 == 0 ? "" : " "+ solve(num%1000000000));
    }

}
