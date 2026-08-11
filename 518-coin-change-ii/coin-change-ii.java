class Solution {
    private static final int IF=10000000;
    public int change(int amount,int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=solve(coins,amount,0,dp);
        return ans;
    }
    private int solve(int[] coins,int amt,int st,int[][] dp){
        if(amt==0)return 1;
        if(st==coins.length)return 0;
        if(dp[st][amt]!=-1)return dp[st][amt];
        int take=0;
        if(coins[st]<=amt){
            take=solve(coins,amt-coins[st],st,dp);
        }
        int notTake=solve(coins,amt,st+1,dp);
        return dp[st][amt]=(take+notTake);
    }
}