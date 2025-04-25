package practice;

import java.util.*;

class RandomizedSet {

    List<Integer> list;
    Map<Integer,Integer> map;
    public RandomizedSet() {
        // all elements go here
        this.list =  new ArrayList<>();
        // element --> index go here
        this.map = new HashMap<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        int key = list.size();
        map.put(val,key);
        list.add(val);
        return true;
    }



    public int getRandom() {
        Random random = new Random();
        System.out.println();
       return this.list.get(random.nextInt(this.list.size()));

    }
}
