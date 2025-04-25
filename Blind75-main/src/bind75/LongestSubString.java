package bind75;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {

        if(s.equals("")) {
            return 0;
        }

        if(s.isBlank() || s.length()==1) {
            return 1;
        }


        int MAX_LENGTH = Integer.MIN_VALUE;
        int end=0;
        Set<Character> set = new HashSet<>();
        while (end<=s.length()-1) {
            if(set.contains(s.charAt(end))) {
                int length = set.size();
                if(length > MAX_LENGTH) {
                    MAX_LENGTH = length;
                }
                set.clear();
                set.add(s.charAt(end));
                end++;
            } else {
                set.add(s.charAt(end));
                end ++;
            }
        }
        int length = set.size();
        if(length > MAX_LENGTH) {
            MAX_LENGTH = length;
        }
        return MAX_LENGTH;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
