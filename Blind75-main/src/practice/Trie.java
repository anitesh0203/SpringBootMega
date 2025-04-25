package practice;


import java.util.ArrayList;
import java.util.List;

class Nodee {
    public static int myAtoi(String s) {
        String str = new String();
        Integer.
        str = s.strip();
        str = str.substring(1,str.length());
        boolean negative= false;
        String ans ="";
        for(char ch : str.toCharArray()) {
            if(ch=='-') {
                negative = true;
            } else if (ch+0>=49 && ch+0<=57) {
                    ans = ans.concat(String.valueOf(ch-48));
            } else if (ch+0!=48) {
                 break;
            }

        }
        if(ans==null || ans =="") {
            return 0;
        }
        int finalAns =  Integer.parseInt(ans);
        if(negative){
            finalAns = (-1) * finalAns;
        }
        return finalAns;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));
    }
}
