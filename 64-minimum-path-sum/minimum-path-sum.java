class Solution {
    int m,n;
    public int minPathSum(int[][] grid) {
        m=grid.length;n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] d:dp)Arrays.fill(d,-1);
        return solve(grid,0,0,dp);
    }
    private int solve(int[][] grid,int i,int j,int[][] dp){
        if(i==m||j==n)return 100000;
        if(i==m-1&&j==n-1)return grid[i][j];
        if(dp[i][j]!=-1)return dp[i][j];
        int sum=Integer.MAX_VALUE;
        sum=Math.min(sum,grid[i][j]+solve(grid,i+1,j,dp));
        sum=Math.min(sum,grid[i][j]+solve(grid,i,j+1,dp));
        return dp[i][j]=sum;
    }
}