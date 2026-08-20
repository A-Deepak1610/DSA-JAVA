class Solution {
    int m,n;
    int[][][] dp;
    int[] d={-1,0,1};
    public int cherryPickup(int[][] grid) {
        m=grid.length;n=grid[0].length;
        dp=new int[m][n][n];
        for(int[][] d1:dp){
            for(int[] d:d1)Arrays.fill(d,-1);
        }
        return solve(grid,0,0,n-1);
    }
    private int solve(int[][] grid,int i,int j1,int j2){
        if(j1<0||j1>=n||j2<0||j2>=n)return -100000;
        if(i==m-1){
            if(j1==j2)return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
        int ans=0;
        for(int J1:d){
            for(int J2:d){
                int nj1=j1+J1;
                int nj2=j2+J2;
                if(j1==j2)ans=Math.max(ans,grid[i][j1]+solve(grid,i+1,nj1,nj2));
                else ans=Math.max(ans,grid[i][j1]+grid[i][j2]+solve(grid,i+1,nj1,nj2));
            }
        }
        return dp[i][j1][j2]=ans;
    }
}