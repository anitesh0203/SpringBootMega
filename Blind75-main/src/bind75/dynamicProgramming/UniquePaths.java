package bind75.dynamicProgramming;

public class UniquePaths {

    int count =0;
    public void uniquePaths(int m, int n, int right, int down) {
        if(right == m-1 && down ==n-1) {
            count ++;
        }
        if(right >= m ) {
            return;
        }
        if(down >= n) {
            return;
        }
        uniquePaths(m,n,right+1,down);
        uniquePaths(m,n,right,down+1);
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.uniquePaths(3,7,0,0);
        System.out.println(uniquePaths.count);
    }

}


