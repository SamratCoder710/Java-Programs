package com.coder.sanam;

import java.util.*;

public class Router {

    public static void main(String[] args) {
        Router router = new Router(3);
        System.out.println(router.addPacket(1,4,90));
        System.out.println(router.addPacket(2,5,90));
        System.out.println(router.addPacket(1,4,90));
        System.out.println(router.addPacket(3,5,95));
        System.out.println(router.addPacket(4,5,105));
        Arrays.stream(router.forwardPacket()).forEach(System.out::println);
        System.out.println(router.addPacket(5,2,110));
        System.out.println(router.getCount(5,100,110));

    }

    class Route{
        int source;
        int destination;
        int timestamp;
        public Route(int source,int destination,int timestamp){
            this.destination = destination;
            this.source =source;
            this.timestamp = timestamp;
        }

    }

    Map<Integer, List<Integer>> destTsMap;
    Queue<Route> routes;
    Set<String> set;
    int size;

    public Router(int memoryLimit) {
        destTsMap = new HashMap<>();
        routes = new LinkedList<>();
        set = new HashSet<>();
        size = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        if(set.contains(createStringElement(source,destination,timestamp))){
            return false;
        }
        if(routes.size() == size){
            Route remove = routes.remove();
            set.remove(createStringElement(remove.source,remove.destination,remove.timestamp));
            List<Integer> values = destTsMap.get(remove.destination);
            if(values.size() == 1){
                destTsMap.remove(remove.destination);
            }else{
                values.remove(Integer.valueOf(remove.timestamp));
                destTsMap.put(remove.destination,
                        values);
            }
        }
        routes.add(new Route(source,destination,timestamp));
        set.add(createStringElement(source,destination,timestamp));
        List<Integer> value = destTsMap.getOrDefault(destination, new ArrayList<>());
        value.add(timestamp);
        destTsMap.put(destination,value);
        return true;
    }

    private String createStringElement(int source, int destination, int timestamp) {
        return String.format("%d::%d::%d",source,destination,timestamp);
    }

    public int[] forwardPacket() {
        Route poll = routes.poll();
        if(poll == null) return new int[]{};
        set.remove(createStringElement(poll.source, poll.destination, poll.timestamp));
        List<Integer> values = destTsMap.get(poll.destination);
        if(values.size() == 1){
            destTsMap.remove(poll.destination);
        }else{
            values.remove(Integer.valueOf(poll.timestamp));
            destTsMap.put(poll.destination,
                    values);
        }
        return new int[]{poll.source, poll.destination, poll.timestamp};

    }

    public int getCount(int destination, int startTime, int endTime) {
        int sum = 0;
        List<Integer> tsValues = destTsMap.getOrDefault(destination,new ArrayList<>());
        for(int i : tsValues){
            if(i>= startTime && i<= endTime){
                sum++;
            }
        }
        return sum;
    }
}
