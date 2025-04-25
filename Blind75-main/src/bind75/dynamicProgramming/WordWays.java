package bind75.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class WordWays {
    Map<String, Integer> map;
    public WordWays() {
        this.map = new HashMap<>();
    }
    public int count =0 ;
    public void  ways(String ip) {
        if(ip==null) {
            return;
        }
        if(ip.length()==0) {
            count++;
            return;
        }
        if(ip.length()>=2 && determineValidNumberTwoDigit(ip.substring(ip.length()-2,ip.length()))) {
               ways(ip.substring(0,ip.length()-2));
        }
        if(ip.length()>=1 && determineValidNumberOneDigit(ip.substring(ip.length()-1, ip.length()))) {
             ways(ip.substring(0,ip.length()-1));
        }
        ways(null);
    }

    private boolean determineValidNumberOneDigit(String ip) {
        if(ip.contains("0")) {
            return false;
        }
        return true;
    }

    private boolean determineValidNumberTwoDigit(String ip) {
        if(ip.contains("0") && Integer.parseInt(ip)<10) {
            return false;
        }
         return Integer.parseInt(ip)<=26;
    }

    public static void main(String[] args) {
        WordWays wordWays = new WordWays();
        wordWays.ways("06");
        System.out.println(wordWays.count);
    }
}
