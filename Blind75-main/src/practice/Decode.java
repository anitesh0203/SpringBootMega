package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Decode {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i=0 ;i < s.length();i++) {
            if(s.charAt(i)==']') {
                String temp = "";
                while(!(stack.peek().equals("["))) {
                    temp = temp.concat(stack.pop());
                }
                stack.pop();
//                int times = Integer.parseInt(stack.pop());
                int times = getTimes(stack);
                String ans = "";
                StringBuilder tem = new StringBuilder(temp);
                tem = tem.reverse();
                for (int j=0 ;j<times;j++) {
                    ans = ans.concat(tem.toString());
                }
                stack.push(ans);
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        String temp = "";
        for (int i=list.size()-1 ;i>=0; i--) {
            temp = temp.concat(list.get(i));
        }
        return temp;
    }

    private int getTimes(Stack<String> stack) {
        String nums = "" ;
        int i =0 ;
        while ( !stack.isEmpty() && stack.peek().matches("[0-9]")) {
            nums = nums.concat(stack.pop());
        }
        StringBuilder sbc = new StringBuilder(nums);
        return Integer.parseInt(sbc.reverse().toString());
    }

    public static void main(String[] args) {
        Decode decode = new Decode();
        String ans = decode.decodeString("100[leetcode]");
        System.out.println(ans);
    }
}
