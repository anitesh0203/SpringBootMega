package practice;

public class KnapsackBottomUp {

    public int knapsack(int wt[], int val[], int weight, int n) {
        int [][] t = new int[weight+1][n+1];

        //Initialse the matrix for weight =0 and n=0
        for(int i=0 ;i<weight+1;i++ ) {
            t[i][0] = 0;
        }

        for(int i=0 ;i<n+1;i++ ) {
            t[0][i] = 0;
        }

        for (int i=1 ; i<weight+1;i++) {
            for(int j=1 ; j<n+1;j++) {
                if(wt[j-1]<=i) {
                    t[i][j] = Math.max(val[j-1]+t[i-wt[j-1]][j-1], t[i][j-1]);
                } else{
                    t[i][j] =  t[i][j-1];
                }
            }
        }
        return t[weight][n];
    }
    public static void main(String[] args) {
        int wt [] = {10,20,30} ;
        int value [] = {60,100,120};
        KnapscakRecursive knapscakRecursive = new KnapscakRecursive();
        System.out.println(knapscakRecursive.knapsack(wt,value,50,3));
    }
}
