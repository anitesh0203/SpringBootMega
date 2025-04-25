//package practice;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.IntStream;
//
//public class Bichhu {
//
//    public int tatya (int []nums, int n) {
//        //base condition
//        if(n<=-1) {
//            return 1;
//        }
//        return Math.max((nums[n]*tatya(nums,n-1)),tatya(nums,n-1));
//    }
//
//    public List<Integer> lexicalOrder(int n) {
//        List<Integer> list = new ArrayList<>();
//        IntStream.range(1,n+1).forEach(x->{
//            list.add(x);
//        });
//
//    }
//
//
//    public int maxProduct(int[] nums) {
//        return tatya(nums,nums.length-1);
//    }
//    public static void main(String[] args) {
//        Bichhu bichhu = new Bichhu();
//        System.out.println(bichhu.maxProduct(new int []{2,3,-2,4}));
//    }
//}
