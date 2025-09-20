package com.coder.sanam;

import java.util.*;

public class MostPopularVideoCreator {

    public static void main(String[] args) {
        MostPopularVideoCreator mostPopularVideoCreator = new MostPopularVideoCreator();
        List<List<String>> lists = mostPopularVideoCreator.mostPopularCreator(
                new String[]{"alice", "bob", "alice", "chris"},
                new String[]{"one", "two", "three", "four"},
                new int[]{5, 10, 5, 4}
        );

        System.out.println(lists);
    }

    class Creation {
        String id;
        long views;

        Creation(String id, long views) {
            this.id = id;
            this.views = views;
        }
    }

    Map<String, Long> creatorViewsMap = new HashMap<>();
    Map<String, TreeSet<Creation>> creatorVideoMap = new HashMap<>();

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        for (int idx = 0; idx < n; idx++) {
            long viewCount = creatorViewsMap.getOrDefault(creators[idx], 0l);
            viewCount += views[idx];
            creatorViewsMap.put(creators[idx], viewCount);

            TreeSet<Creation> set = creatorVideoMap.getOrDefault(creators[idx], new TreeSet<>((a, b) -> {
                if (a.views != b.views) {
                    return Long.compare(b.views,a.views);
                } else {
                    return a.id.compareTo(b.id);
                }
            }));

            set.add(new Creation(ids[idx], views[idx]));
            creatorVideoMap.put(creators[idx], set);
        }

        List<List<String>> resultList = new ArrayList<>();
        long maxVew = creatorViewsMap.values().stream().max(Comparator.naturalOrder()).orElse(0l);
        for (Map.Entry<String, Long> entry : creatorViewsMap.entrySet()) {
            if (entry.getValue() == maxVew) {
                List<String> eleList = List.of(entry.getKey(), creatorVideoMap.get(entry.getKey()).first().id);
                resultList.add(eleList);
            }
        }
        return resultList;
    }
}

