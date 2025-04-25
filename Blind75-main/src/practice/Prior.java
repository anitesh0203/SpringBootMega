package practice;

import java.util.*;

public class Prior {

    PriorityQueue<Integer> pq;
    int k;

    public Prior(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        for (int x : nums) {
            this.pq.add(x);
        }
        this.k = k;
    }

    public int add(int val) {
//        List<Integer> list = new ArrayList<>();
//        this.pq.add(val);
//        for (int i=0 ;i<k-1;i++) {
//            list.add(pq.poll());
//        }
        int ans = pq.poll();
//        for (int x : list) {
//            pq.add(x);
//        }
        return ans;
    }


    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x: stones) {
            pq.add(x);
        }
        while (!pq.isEmpty()) {
            if(pq.size()>1) {
                int a = pq.poll();
                int b = pq.poll();
                if(Math.abs(a-b)>0) {
                    pq.add(Math.abs(a-b));
                }
            } else {
                return pq.poll();
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(4);
        pq.add(1);
        pq.add(2);
        pq.add(2);
        pq.add(2);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());



    }

}
