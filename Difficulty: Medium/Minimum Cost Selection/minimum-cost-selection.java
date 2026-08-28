class Solution {
    int[][] dp;
    public int minCost(int[][] mat) {
        dp=new int[mat.length][4];
        for(int[] d:dp)Arrays.fill(d,-1);
        return solve(mat,0,0);
    }
    private int solve(int[][] mat,int i,int j){
        if(i==mat.length)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int minCost=Integer.MAX_VALUE;
        for(int k=1;k<4;k++){
            if(k==j)continue;
            minCost=Math.min(minCost,mat[i][k-1]+solve(mat,i+1,k));
        }
        return dp[i][j]=minCost;
    }
}