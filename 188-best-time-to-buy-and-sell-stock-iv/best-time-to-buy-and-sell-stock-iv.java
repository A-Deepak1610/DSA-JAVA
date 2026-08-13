class Solution {
    public int maxProfit(int k,int[] prices) {
        int[][][] dp=new int[prices.length][2][k+1];
        for(int[][] d:dp){
            for(int[] d1:d)Arrays.fill(d1,-1);
        }
        return solve(prices,0,true,k,dp);
    }
    private int solve(int[] prices,int idx,boolean canBuy,int transcation,int[][][] dp){
        if(idx==prices.length||transcation==0)return 0;
        int profit=0;
        if(dp[idx][canBuy?0:1][transcation]!=-1)return dp[idx][canBuy?0:1][transcation];
        if(canBuy){
            int buy=-prices[idx]+solve(prices,idx+1,false,transcation,dp);
            int skip=solve(prices,idx+1,canBuy,transcation,dp);
            profit=Math.max(buy,skip);
        }
        else{
            int sell=prices[idx]+solve(prices,idx+1,true,transcation-1,dp);
            int skip=solve(prices,idx+1,canBuy,transcation,dp);
            profit=Math.max(sell,skip);
        }
        return dp[idx][canBuy?0:1][transcation]=profit;
    }
}