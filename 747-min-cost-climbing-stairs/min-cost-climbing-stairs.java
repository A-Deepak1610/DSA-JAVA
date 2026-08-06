class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int c1=minCost(cost,0,dp);
        int c2=minCost(cost,1,dp);
        return Math.min(c1,c2);
    }
    private int minCost(int[] cost,int st,int[] dp){
        if(st>=cost.length){
            return 0;
        }
        if(dp[st]!=-1)return dp[st];
        dp[st]=cost[st]+Math.min(minCost(cost,st+1,dp),minCost(cost,st+2,dp));
        return dp[st];
    }
}