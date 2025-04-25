//package bind75.dynamicProgramming;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class WordBreak {
//
//
//
//    public int rob(int[] nums, int n) {
//        //nums = [2,7,9,3,1]
//
//        if(n==-1) {
//            return 0;
//        }
//        Math.a
//
//    }
//
//
//
//
//    public boolean splitWord(String word, int i, int j,List<String> wordDict) {
//        if(i>=j) {
//            return false;
//        }
//
//        if(wordDict.contains(word.substring(i,j+1))) {
//            return true;
//        }
//        boolean temp = false;
//
//        for (int k=i;k<=j-1;k++) {
//             temp = splitWord(word,i,k,wordDict) && splitWord(word,k+1,j,wordDict);
//        }
//        return temp;
//    }
//
//
//    public boolean wordBreak(String s, List<String> wordDict) {
//            return splitWord(s,0,s.length()-1,wordDict);
//    }
//
//    public static void main(String[] args) {
//
//        String[] arrays= {"cats","dog","sand","and","cat"};
//        List<String> list = Arrays.asList(arrays);
//        WordBreak wordBreak = new WordBreak();
//        System.out.println(wordBreak.wordBreak("catsanddog",list));
//
//    }
//}
