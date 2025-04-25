package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Gareeb {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(stones).forEach(x->{
            priorityQueue.add(x);
        });
        while (priorityQueue.size()>1) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            int result = Math.abs(a-b);
            if(result!=0) {
                priorityQueue.add(result);
            }
        }
        if(null != priorityQueue && priorityQueue.size()>0) {
            return priorityQueue.size()>0?priorityQueue.poll():null;
        }
        return -1;
    }
}
