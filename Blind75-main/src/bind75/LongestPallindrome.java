package bind75;

public class LongestPallindrome {
    public String lp(String a, String b, int x, int y) {

        String max = "";

        String t[][] = new String [x+1][y+1];
        for (int i=0;i<=x;i++) {
            t[i][0] = "";
        }
        for (int i=0;i<=y;i++) {
            t[0][i] = "";
        }

        for ( int i=1;i<=x;i++) {
            for(int j=1;j<=y;j++) {
                if(a.charAt(i-1)==b.charAt(j-1)) {
                    t[i][j] = a.charAt(i-1)+t[i-1][j-1];
                } else {
                    t[i][j] = "";
                }
            }
        }
        for ( int i=1 ; i<x+1; i++) {
            for (int j=1;j<y+1;j++) {
                if(t[i][j].length()>max.length()) {
                    max = t[i][j];
                }

            }
        }
            return max;
    }
    public String longestPalindrome(String s) {
            return lp(s,reverse(s),s.length(),s.length());
    }

    public String reverse(String str) {
        StringBuilder rev = new StringBuilder(str);
        return rev.reverse().toString();
    }
    public static void main(String[] args) {
        LongestPallindrome l = new LongestPallindrome();
        System.out.println(l.longestPalindrome("aacabdkacaa"));
    }
}
