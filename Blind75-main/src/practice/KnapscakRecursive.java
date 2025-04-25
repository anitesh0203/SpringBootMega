package practice;

public class KnapscakRecursive {

    // signature weight and n will vary across the recursive calls
    public int knapsack(int []wt, int [] val, int weight, int n) {
        //base condition, if the weight has been fulfilled or all items visited
        if(n==0 || weight==0) {
            return 0;
        }

        if(wt[n-1]<=weight) {
            return Math.max(val[n-1]+knapsack(wt,val,weight-wt[n-1],n-1), knapsack(wt,val,weight,n-1));
        } else {
            return knapsack(wt, val, weight, n-1);
        }

    }



    public static void main(String[] args) {
        int wt [] = {10,20,30} ;
        int value [] = {60,100,120};
        KnapscakRecursive knapscakRecursive = new KnapscakRecursive();
        System.out.println(knapscakRecursive.knapsack(wt,value,50,3));
    }
}
