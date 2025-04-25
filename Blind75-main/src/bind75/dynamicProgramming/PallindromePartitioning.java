//package bind75.dynamicProgramming;
//
//public class PallindromePartitioning {
//
//        public int pp(char[] input, int i, int j) {
//            if(i>=j) {
//                return 0;
//            }
//
//            if(isPallindrome(input, i,j)) {
//                return 0;
//            }
//            int min = Integer.MAX_VALUE;
//            for(int k=i;k<=j-1;k++) {
//                int temp = pp(input,i,k)+pp(input,k+1,j)+1;
//                min = temp<min?temp:min;
//            }
//        return min;
//        }
//
//    private boolean isPallindrome(char[] input, int i, int j) {
//            while(i<=j){
//                if(input[i]!=input[j]) {
//                    return false;
//                }
//                i++;j--;
//            }
//            return true;
//    }
//
//
//    public boolean parethesis(){
//
//    }
//    public static void main(String[] args) {
//        PallindromePartitioning p = new PallindromePartitioning();
//        String input ="nitinp";
//
//        System.out.println(p.pp(input.toCharArray(), 0, input.length()-1));
//    }
//}
