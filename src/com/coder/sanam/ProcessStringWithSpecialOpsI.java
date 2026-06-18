package com.coder.sanam;

public class ProcessStringWithSpecialOpsI {

    public static void main(String[] args) {
        ProcessStringWithSpecialOpsI processStringWithSpecialOpsI = new ProcessStringWithSpecialOpsI();
        String result = processStringWithSpecialOpsI.processStr("ab*c#d%");
        System.out.println(result);
    }

    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (ch == '#') {
                sb.append(sb);
            } else if (ch == '%') {
                sb.reverse();
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
