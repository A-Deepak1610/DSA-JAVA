class Solution {
    int m,n;
    int[][][][] dp;
    public int cherryPickup(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp=new int[m][n][m][n];
        for(int[][][] d1:dp){
            for(int[][] d2:d1){
                for(int[] d3:d2)Arrays.fill(d3,-1);
            }
        }
        int res=solve(grid,0,0,0,0);
        return res<0?0:res;
    }
    private int solve(int[][] grid,int r1,int c1,int r2,int c2){
        if(r1>=m||c1>=n||r2>=m||c2>=n||grid[r1][c1]==-1||grid[r2][c2]==-1)return -1000000;
        if(r1==m-1&&c1==n-1&&r2==m-1&&c2==n-1)return grid[r1][c1];
        if(dp[r1][c1][r2][c2]!=-1)return dp[r1][c1][r2][c2];
        int ans=Integer.MIN_VALUE;
        ans=Math.max(ans,solve(grid,r1+1,c1,r2+1,c2));
        ans=Math.max(ans,solve(grid,r1+1,c1,r2,c2+1));
        ans=Math.max(ans,solve(grid,r1,c1+1,r2+1,c2));
        ans=Math.max(ans,solve(grid,r1,c1+1,r2,c2+1));
        if(r1==r2&&c1==c2){
            return dp[r1][c1][r2][c2]=ans+grid[r1][c1];
        }
        return dp[r1][c1][r2][c2]=ans+grid[r1][c1]+grid[r2][c2];
    }
}