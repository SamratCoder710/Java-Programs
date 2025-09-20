package com.coder.sanam;

public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
        String s = excelSheetColumnTitle.convertTitle(701);
        System.out.println(s);
    }

    public String convertTitle(int columnNumber){
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0){
            columnNumber--;
            int lastDigit = columnNumber % 26;
            char ch = (char) ('A' + lastDigit);
            sb.append(ch);
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }
}
