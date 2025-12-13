package com.coder.sanam;

import java.util.*;

public class CountMentionsPerUser {

    public static void main(String[] args) {

        // Input: numberOfUsers = 2, events = [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","71","HERE"]]
        CountMentionsPerUser obj = new CountMentionsPerUser();
        List<List<String>> events1 = new ArrayList<>();
        events1.add(new ArrayList<>(List.of("MESSAGE","10","id1 id0")));
        events1.add(new ArrayList<>(List.of("OFFLINE","11","0")));
        events1.add(new ArrayList<>(List.of("MESSAGE","71","HERE")));

        System.out.println(Arrays.toString(obj.countMentions(2, events1)));

        //Input : numberOfUsers = 3 ; Modifiable List [["MESSAGE","2","HERE"],["OFFLINE","2","1"],["OFFLINE","1","0"],["MESSAGE","61","HERE"]]
        List<List<String>> events2 = new ArrayList<>();
        events2.add(new ArrayList<>(List.of("MESSAGE","2","HERE")));
        events2.add(new ArrayList<>(List.of("OFFLINE","2","1")));
        events2.add(new ArrayList<>(List.of("OFFLINE","1","0")));
        events2.add(new ArrayList<>(List.of("MESSAGE","61","HERE")));

        System.out.println(Arrays.toString(obj.countMentions(3, events2)));
    }


    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        boolean[] isOnline = new boolean[numberOfUsers];
        Arrays.fill(isOnline,true);
        int[] availableAt = new int[numberOfUsers];
        int[] mentions = new int[numberOfUsers];
        int eventSize = events.size();
        Collections.sort(events, (a,b) ->
        {
            if(Integer.parseInt(a.get(1)) != Integer.parseInt(b.get(1))){
                return Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1));
            }
            return b.get(0).compareTo(a.get(0));
        });
        for(int i=0;i<eventSize;i++){
            String eventType = events.get(i).get(0);
            String mentionString = events.get(i).get(2);
            int timeStamp = Integer.parseInt(events.get(i).get(1));
            if(eventType.equals("MESSAGE")){
                if(mentionString.equals("ALL")){
                    for(int m=0;m<numberOfUsers;m++){
                        mentions[m] += 1;
                    }
                }else if(mentionString.equals("HERE")){
                    //Offline to Online logic
                    for(int k=0;k<numberOfUsers;k++){
                        if(isOnline[k]) continue;
                        if(timeStamp >= availableAt[k]){
                            isOnline[k] = true;
                        }
                    }

                    for(int n=0;n<numberOfUsers;n++){
                        if(isOnline[n]){
                            mentions[n] += 1;
                        }
                    }
                }else{
                    String[] idList = mentionString.replaceAll("id","").split(" ");
                    for(String s: idList){
                        mentions[Integer.parseInt(s)] += 1;
                    }
                }
            }else{
                int offlineId = Integer.parseInt(mentionString);
                isOnline[offlineId] = false;
                availableAt[offlineId] = timeStamp + 60;
            }
        }
        return mentions;
    }
}
