package practice;

import java.util.*;
import java.util.stream.Collectors;

public class TwoD {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int [][] copy = new int[intervals.length+1][2];
        for (int i =0 ;i< intervals.length;i++) {
            copy[i] = intervals[i];
        }
        copy[intervals.length] = newInterval;

        Arrays.sort(copy, Comparator.comparingInt(row -> row[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(copy[0]);
        for (int i =1 ;i< copy.length; i++) {
            //check all conditions
            int[] ptr = stack.peek();
            //[3,5],[4,8]
            if(ptr[1]>=copy[i][0]) {
                // [3,9][4,8]
                if(ptr[1]>=copy[i][1]) {
                  // do nothing
                } else{
                    ptr = stack.pop();
                    ptr[1] = copy[i][1];
                    stack.push(ptr);
                }
            }//[3,5],[5,8]
            else if(ptr[1]==copy[i][0]) {
                ptr = stack.pop();
                ptr[1] = copy[i][1];
                stack.push(ptr);
            } else {
                int []  var = new int[2];
                var [0] = copy[i][0];
                var [1] =  copy[i][1];
                stack.push(var);
            }
        }
        int [][] ans = new int[stack.size()][2];
        int i=0;
        while(!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }

        Collections.reverse(Arrays.asList(ans));

        return ans;
    }


    public static void main(String[] args) {
        int [][] t = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        TwoD twoD = new TwoD();
        twoD.insert(t,new int[]{4,8});
        System.out.println("hello");

        // [[1,3],[6,9]]

    }
}
