package bind75.dynamicProgramming;

public class lcs {
    public int longestCommonSubsequence(String text1, String text2) {
        return locus(text1.toCharArray(), text2.toCharArray(), text1.length()-1, text2.length()-1);
    }
    private int locus(char[] text1, char[] text2, int n, int m) {

        // base
        if(n==0 || m==0) {
            return 0;
        }

        if(text1[n]==text2[m]) {
            return 1+locus(text1,text2,n-1,m-1);
        } else {
            return Math.max(locus(text1,text2,n,m-1), locus(text1,text2,n-1,m));
        }
    }
}
