package com.coder.sanam;

import java.util.Objects;

public class ShortestDistanceToTargetStringCircular {

    public static void main(String[] args) {
        ShortestDistanceToTargetStringCircular shortestDistanceToTargetStringCircular = new ShortestDistanceToTargetStringCircular();
        int result = shortestDistanceToTargetStringCircular.closestTarget(new String[]
                {"hsdqinnoha","mqhskgeqzr","zemkwvqrww","zemkwvqrww","daljcrktje",
                        "fghofclnwp","djwdworyka","cxfpybanhd","fghofclnwp","fghofclnwp"},"zemkwvqrww",8);
        System.out.println(result);
    }

    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int dist = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(words[i].equals(target)){
                int absDist = Math.abs(startIndex - i);
                dist = Math.min(dist, Math.min(absDist, n - absDist));
            }
        }

        return dist == Integer.MAX_VALUE ? -1 : dist;
    }
}
