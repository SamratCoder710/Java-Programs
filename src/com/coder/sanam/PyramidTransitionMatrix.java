package com.coder.sanam;

import java.util.*;

public class PyramidTransitionMatrix {


    public static void main(String[] args) {
        PyramidTransitionMatrix obj = new PyramidTransitionMatrix();
        String bottom = "AAAA";
        List<String> allowed = Arrays.asList("AAB","AAC","BCD","BBE","DEF");
        System.out.println(obj.pyramidTransition(bottom, allowed));
    }

        Map<String, List<Character>> map = new HashMap<>();
        Set<String> failed = new HashSet<>();

        public boolean pyramidTransition(String bottom, List<String> allowed) {
            for (String s : allowed) {
                String key = s.substring(0, 2);
                map.computeIfAbsent(key, _ -> new ArrayList<>()).add(s.charAt(2));
            }
            return canBuild(bottom);
        }

        private boolean canBuild(String row) {
            if (row.length() == 1) return true;
            if (failed.contains(row)) return false;
            return buildNextRow(0, row, new StringBuilder());
        }

        private boolean buildNextRow(int idx, String row, StringBuilder next) {

            if (idx == row.length() - 1) {
                return canBuild(next.toString());
            }
            String key = row.substring(idx, idx + 2);
            if (!map.containsKey(key)) return false;

            for (char ch : map.get(key)) {
                next.append(ch);
                if (buildNextRow(idx + 1, row, next)) return true;
                next.deleteCharAt(next.length() - 1);
            }

            failed.add(row);
            return false;
        }

}
