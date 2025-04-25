package bind75.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    public boolean wordBreak(String s, List<String> wordDict) {
        String [] ans = new String[wordDict.size()];
        int i=0;
        for(String a: wordDict) {
            ans[i++] = a ;
        }
        return tellAns(s, ans, wordDict.size()-1);
    }

    private boolean tellAns(String s, String[] dict, int n) {
        if(s.isEmpty()) {
            return true;
        } if(n==-1) {
            return false;
        }
        if(s.contains(dict[n])){
            return tellAns(removeCommon(s, dict[n]), dict, n-1) || tellAns(s,dict,n-1);
        } else {
            return tellAns(s,dict,n-1);
        }
    }

    public  String removeCommon(String string, String word)
    {
        if (string.contains(word)) {
            string = string.replace(word, "");

        }
        return string;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary.wordBreak("aaaaaaa", list));
    }

}
