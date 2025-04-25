package practice;

public class GhumaDe {

    public void rotate(int[][] matrix) {
        boolean visited [][] = new boolean[matrix.length][matrix[0].length];

        for(int i=0 ;i<matrix.length;i++) {
            for(int j=0 ;j<matrix[0].length;j++){
                if(!visited[i][j] && !visited[j][i]) {
                    int temp;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                    visited[i][j] = true;
                    visited[j][i] = true;
                }
            }
        }
        for(int i=0 ;i<matrix.length;i++) {
            int middle =  matrix[0].length-1;
            for(int j=0 ;j<=middle/2;j++){
                int temp;
                temp = matrix[i][j];
                matrix[i][j] =  matrix[i][middle];
                matrix[i][middle] =  temp;
                middle--;
            }
        }
        System.out.println("hold!");
    }

    public static void main(String[] args) {
        int input [][] = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        GhumaDe ghumaDe = new GhumaDe();
        ghumaDe.rotate(input);

    }
}
