package com.coder.sanam;

public class CompareVersion {


    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
        int i = compareVersion.compareVersionMethod("1.0", "1.0.0.0");
        System.out.println(i);
    }

    public int compareVersionMethod(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n = Math.min(v1.length, v2.length);
        int idx = 0;
        while(idx <n){
            int n1 = Integer.parseInt(v1[idx]);
            int n2 = Integer.parseInt(v2[idx]);
            if(n1 < n2){
                return -1;
            }else if(n1 > n2){
                return 1;
            }
            idx++;
        }

        while(idx < v1.length){
            int n1 = Integer.parseInt(v1[idx]);
            if(n1 != 0 ){
                return 1;
            }
            idx++;
        }
        while(idx < v2.length){
            int n2 = Integer.parseInt(v2[idx]);
            if(n2 != 0 ){
                return -1;
            }
            idx++;
        }
        return 0;

    }
}
