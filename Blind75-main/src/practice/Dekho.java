package practice;

import java.util.Arrays;
import java.util.Stack;

public class Dekho {


    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int ans [] = new int [temperatures.length];
        for (int i=0 ;i< temperatures.length;i++) {
            // iterate over the list
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]) {
                ans[i] = i-stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }




    public int carFleet(int target, int[] position, int[] speed) {
        int [] positionCopy = new int[position.length];
        for (int i=0 ;i<position.length; i++) {
            positionCopy[i] = position[i];
        }
        // sort based on the positions
        Arrays.sort(positionCopy);
        Stack<Float> stack = new Stack<>();
        stack.push((float)((target-positionCopy[position.length-1])/getIndex(positionCopy.length-1,positionCopy,position,speed)));
        for (int i=positionCopy.length-2 ;i>=0; i--) {
            float currTime = stack.peek();
            float existTime = (float)(target-positionCopy[i])/(float)getIndex(i,positionCopy,position,speed);
            if(existTime>currTime) {
                stack.push(existTime);
            }
        }
        return stack.size();
    }

    private int getIndex(int i, int[] positionCopy, int[] position, int[] speed) {
        int key = positionCopy[i];
        int lock = 0;
        for (int ii=0 ;ii<position.length;ii++) {
            if(position[ii]==key) {
                lock = ii;
                break;
            }
        }
        return speed[lock];
    }





    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }



    public static void main(String[] args) {
        Dekho dekho = new Dekho();
        dekho.carFleet(10,new int[] {6,8}, new int[]{3,2});
    }
}
