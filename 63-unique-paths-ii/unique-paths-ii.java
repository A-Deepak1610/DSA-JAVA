class Solution {
    int m,n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m=obstacleGrid.length;this.n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int[] d:dp)Arrays.fill(d,-1);
        return solve(obstacleGrid,0,0,dp);
    }
    private int solve(int[][] obstacleGrid,int i,int j,int[][] dp){
        if(i==m||j==n||obstacleGrid[i][j]==1)return 0;
        if(i==m-1&&j==n-1)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int count=0;
        count+=solve(obstacleGrid,i+1,j,dp);
        count+=solve(obstacleGrid,i,j+1,dp);
        return dp[i][j]=count;
    }
}