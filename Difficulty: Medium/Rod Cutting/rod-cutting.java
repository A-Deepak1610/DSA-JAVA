class Solution {
    public int cutRod(int[] price) {
        int n=price.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(price,n,dp);
    }
    private int solve(int[] price,int len,int[] dp){
        if(len<=0)return 0;
        if(dp[len]!=-1)return dp[len];
        int maxProfit=0;
        for(int i=0;i<price.length;i++){
            if(i+1<=len){
                maxProfit=Math.max(maxProfit,price[i]+solve(price,len-(i+1),dp));
            }
        }
        return dp[len]=maxProfit;
    }
}