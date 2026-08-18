class Solution {
    public int maximumPoints(int mat[][]) {
        int[][] dp=new int[mat.length][3];
        for(int[] d:dp)Arrays.fill(d,-1);
        int maxProfit=0;
        maxProfit=Math.max(maxProfit,mat[0][0]+solve(mat,1,0,dp));
        maxProfit=Math.max(maxProfit,mat[0][1]+solve(mat,1,1,dp));
        maxProfit=Math.max(maxProfit,mat[0][2]+solve(mat,1,2,dp));
        return maxProfit;
    }
    private int solve(int[][] mat,int i,int prev,int[][] dp){
        if(i>=mat.length)return 0;
        if(dp[i][prev]!=-1)return dp[i][prev];
        int maxProfit=0;
        for(int act=0;act<3;act++){
            if(act!=prev){
                maxProfit=Math.max(maxProfit,mat[i][act]+solve(mat,i+1,act,dp));
            }
        }
        return dp[i][prev]=maxProfit;
    }
}