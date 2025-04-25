package bind75;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        char arr [] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i=0 ; i< arr.length; i++) {
            if(arr[i]=='(' || arr[i]=='{' || arr[i]=='[' ) {
                stack.push(arr[i]);
            } else if ((arr[i]==')' || arr[i]=='}' || arr[i]==']') && !stack.empty()) {
                switch (arr[i]){
                    case ')' : {
                        if (stack.peek() != '(') {
                            return false;
                        } else {
                            stack.pop();
                        }
                        break;
                    }
                    case '}' : {
                        if (stack.peek() != '{') {
                            return false;
                        } else {
                            stack.pop();
                        }
                        break;
                    }
                    case ']' : {
                        if (stack.peek() != '[') {
                            return false;
                        } else {
                            stack.pop();
                        }
                        break;
                    }
                }
            } else if ((arr[i]==')' || arr[i]=='}' || arr[i]==']') && stack.empty()) {
                return  false;
            }
        }
        if(stack.isEmpty()) {
            return true;

        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
