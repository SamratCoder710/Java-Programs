package com.coder.sanam;

import java.util.*;

public class CouponCodeValidator {

    public static void main(String[] args) {
        CouponCodeValidator obj = new CouponCodeValidator();
        String[] code = {"SAVE10", "GROCERY20", "PHARMA15", "RESTAURANT5", "INVALID#CODE"};
        String[] businessLine = {"electronics", "grocery", "pharmacy", "restaurant", "electronics"};
        boolean[] isActive = {true, true, false, true, true};
        System.out.println(obj.validateCouponsOptimized(code, businessLine, isActive));
    }

    public record Coupon(String code, String businessLine) {}

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int size = code.length;
        List<Coupon> couponList = new ArrayList<>();
        Set<String> businessLineSet = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        for (int i = 0; i < size; i++) {
            //Bottlenecks : Pattern matching ; Streams ; Sorting ; Coupon object creation; Method reference
            if(code[i].matches("^[a-zA-Z0-9_]+$") && businessLineSet.contains(businessLine[i]) && isActive[i]){
                couponList.add(new Coupon(code[i], businessLine[i]));
            }
        }

        return couponList.stream()
                .sorted(Comparator.comparing(Coupon::businessLine)
                        .thenComparing(Coupon::code))
                .map(x -> x.code).toList();
    }

    static class CouponOptimized {
        String code;
        int businessLineCode;

        public CouponOptimized(String code, int businessLineCode) {
            this.code = code;
            this.businessLineCode = businessLineCode;
        }
    }

    public List<String> validateCouponsOptimized(String[] code, String[] businessLine, boolean[] isActive) {
        int size = code.length;
        List<CouponOptimized> couponList = new ArrayList<>();
        Map<String,Integer> businessLineMap = Map.of(
                "electronics", 0,
                "grocery", 1,
                "pharmacy", 2,
                "restaurant", 3
        );
        for (int i = 0; i < size; i++) {
            if(!isActive[i]) continue;
            if(validCode(code[i]) && businessLineMap.containsKey(businessLine[i])){
                couponList.add(new CouponOptimized(code[i], businessLineMap.get(businessLine[i])));
            }
        }

        couponList.sort((a, b) -> {
            if (a.businessLineCode != b.businessLineCode) {
                return Integer.compare(a.businessLineCode, b.businessLineCode);
            }
            return a.code.compareTo(b.code);
        });

        List<String> result = new ArrayList<>();
        for (CouponOptimized coupon : couponList) {
            result.add(coupon.code);
        }
        return result;
    }

    private boolean validCode(String code){
        for(int i=0; i < code.length(); i++){
            char ch = code.charAt(i);
            if( !( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || ch == '_') ){
                return false;
            }
        }
        return true;
    }




}
