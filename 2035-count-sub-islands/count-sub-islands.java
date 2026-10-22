class Solution {
    int m,n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m=grid1.length;
        n=grid1[0].length;
        int subIslands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1&&grid1[i][j]==1){
                    if(dfs(grid1,grid2,i,j))
                    subIslands++;
                }
            }
        }
        return subIslands;
    }
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return true;
        if (grid2[i][j] == 0) return true;
        boolean valid = grid1[i][j] == 1;
        grid2[i][j] = 0;
        grid1[i][j] = 0;
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);
        return valid && up && down && left && right;
    }
}