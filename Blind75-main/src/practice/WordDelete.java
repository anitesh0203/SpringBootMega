package practice;

import java.util.Stack;

public class WordDelete {

    public String removeDuplicates(String s, int k) {
        // we need to push the chars in stack as we ieterate

        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ;i<sb.length();i++) {
            if(i==0 || sb.charAt(i)!=sb.charAt(i-1)) {
                stack.push(1);
            } else {
                int val = stack.pop();
                ++val;
                if(val==k) {
                    //remove the elements
                    sb.delete(i-k+1,i+1);
                    i = i-k;
                } else {
                    stack.push(val);
                }
            }

        }
        return sb.toString();
    }


    public static void main(String[] args) {
        WordDelete wordDelete = new WordDelete();
        System.out.println(wordDelete.removeDuplicates("iiiixxxxxiiccccczzffffflllllllllfffffllyyyyyuuuuuz",2));
    }
}
