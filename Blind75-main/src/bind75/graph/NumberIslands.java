package bind75.graph;

public class NumberIslands {
    public int numIslands(char[][] grid) {

        //this maintains the number of islands
        int count = 0;
        //traverse each element in the 2d array
        for (int i=0 ; i< grid.length; i++) {
            for(int j=0 ;j<grid[i].length;j++ ) {
                if(grid[i][j]=='1') {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i<0 || j <0 || i >=grid.length || j>=grid[0].length || grid[i][j]!='1') {
            return;
        }
        grid[i][j] = 'x';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);

    }
}
