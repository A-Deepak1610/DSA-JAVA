class Solution {
    int minProfit;
    int[] group;
    int[] profit;
    Integer[][][] dp;
    int mod=(int)1e9+7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        this.minProfit=minProfit;
        this.group=group;
        this.profit=profit;
        dp=new Integer[n+1][minProfit+1][profit.length];
        return solve(n,0,0);
    }
    private int solve(int rem,int p,int i){
        if(i==profit.length)return p>=minProfit?1:0;
        if(dp[rem][p][i]!=null)return dp[rem][p][i];
        int count=0;
        count=solve(rem,p,i+1)%mod;//not take;
        if(rem-group[i]>=0){
            int newProfit=Math.min(minProfit,p+profit[i]);
            count=(count+solve(rem-group[i],newProfit,i+1))%mod;//take
        }
        return dp[rem][p][i]=count;
    }
}