package practice;

import java.util.*;
import java.util.stream.Collectors;

public class Powerrrrr {

    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // calculate the kth power

        for (int i=lo ;i<=hi;i++) {
            int pow = getPower(i);
            map.put(i,pow);
        }

        // put in a map

        // sort the map

         map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }


        Iterator<Map.Entry<Integer, Integer>> itr = result.entrySet().iterator();
        int start =0;
        while(itr.hasNext()) {
            start++;
            if(start==k) {
                return itr.next().getKey();
            }
            itr.next();
        }

        return 0;
    }

    private int getPower(int i) {
        int steps =0;
        while(i!=1) {
            steps++;
            if(i%2==0) {
                i=i/2;
            } else {
                i=i*3+1;
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        Powerrrrr poww = new Powerrrrr();
        System.out.println(poww.getKth(7,11,4));
    }
}
