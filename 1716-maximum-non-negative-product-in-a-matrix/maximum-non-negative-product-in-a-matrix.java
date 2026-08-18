class Solution {
    long[][] minDp;
    long[][] maxDp;
    boolean[][] visited;
    int m,n;
    public int maxProductPath(int[][] grid) {
        this.m=grid.length;this.n=grid[0].length;
        minDp=new long[m][n];
        maxDp=new long[m][n];
        visited=new boolean[m][n];
        long ans=solve(grid,0,0)[1];
        return ans>=0?(int)(ans%1000000007):-1;
    }
    private long[] solve(int[][] grid,int i,int j){
        if(i==m-1&&j==n-1){
            return new long[]{grid[i][j],grid[i][j]};
        }
        if(visited[i][j])return new long[]{minDp[i][j],maxDp[i][j]};
        visited[i][j]=true;
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        if(j<n-1){
            long[] ans=solve(grid,i,j+1);
            min=Math.min(min,grid[i][j]*ans[0]);
            min=Math.min(min,grid[i][j]*ans[1]);
            max=Math.max(max,grid[i][j]*ans[0]);
            max=Math.max(max,grid[i][j]*ans[1]);
        }
        if(i<m-1){
            long[] ans=solve(grid,i+1,j);
            min=Math.min(min,grid[i][j]*ans[0]);
            min=Math.min(min,grid[i][j]*ans[1]);
            max=Math.max(max,grid[i][j]*ans[0]);
            max=Math.max(max,grid[i][j]*ans[1]);
        }
        minDp[i][j]=min;
        maxDp[i][j]=max;
        return new long[]{minDp[i][j],maxDp[i][j]};
    }
}