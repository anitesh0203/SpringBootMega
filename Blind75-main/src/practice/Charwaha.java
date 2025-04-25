package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Charwaha {

    Map<Integer,Boolean> map = new HashMap<>();
    public boolean dp (String s, List<String> dict, int i) {
        if(map.get(i)!=null) {
            return map.get(i);
        }
        if(i>=s.length()){
            map.put(i,true);
            return map.get(i);
        }

        //break and check

        for (int k = i;k<s.length()+1;k++) {
            if(dict.contains(s.substring(i,k)) && dp(s,dict,k)) {
                map.put(i,true);
                return map.get(i);
            }
        }
        map.put(i,false);
        return map.get(i);
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        return dp(s,wordDict,0);
    }

    public static void main(String[] args) {
        Charwaha charwaha = new Charwaha();
        List<String> list = Arrays.asList("leet","code");
        System.out.println(charwaha.wordBreak("leetcode",list));
    }
}


