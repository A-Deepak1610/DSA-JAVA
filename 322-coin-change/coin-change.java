class Solution {
    private static final int IF=10000000;
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=solve(coins,amount,0,dp);
        return ans==IF?-1:ans;
    }
    private int solve(int[] coins,int amt,int st,int[][] dp){
        if(amt==0)return 0;
        if(st==coins.length)return IF;
        if(dp[st][amt]!=-1)return dp[st][amt];
        int take=IF;
        if(coins[st]<=amt){
            take=1+solve(coins,amt-coins[st],st,dp);
        }
        int notTake=solve(coins,amt,st+1,dp);
        return dp[st][amt]=Math.min(take,notTake);
    }
}