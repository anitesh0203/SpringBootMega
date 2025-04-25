package bind75;

import java.util.*;

public class GroupAanagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>>  map = new HashMap<>();

        for (String str : strs) {
            if(map.containsKey(getKey(str))) {
                List<String> entry = map.get(getKey(str));
                entry.add(str);
                map.put(getKey(str), entry);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(getKey(str),list );

            }
        }

            List<List<String>> ansList = new ArrayList<>();


        for (List<String> a : map.values()) {
            ansList.add(a);
        }

        return ansList;

    }

    private String getKey(String str) {
            char []arr = str.toCharArray();
            Arrays.sort(arr);
            return (String.valueOf(arr));
    }

    public static void main(String[] args) {
        GroupAanagrams gr = new GroupAanagrams();
        String ans [] = {"ddddddddddg","dgggggggggg"} ;
        gr.groupAnagrams(ans);
    }

}
