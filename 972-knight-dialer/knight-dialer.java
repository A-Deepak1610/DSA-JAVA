class Solution {
    int mod=1000000007;
    int[][] moves = {
        {4, 6},       // 0
        {6, 8},       // 1
        {7, 9},       // 2
        {4, 8},       // 3
        {0, 3, 9},    // 4
        {},           // 5
        {0, 1, 7},    // 6
        {2, 6},       // 7
        {1, 3},       // 8
        {2, 4}        // 9
    };
    public int knightDialer(int n) {
        long ans=0;
        long[][] dp=new long[10][n+1];
        for(long[] d:dp){
            Arrays.fill(d,-1);
        }
        for(int i=0;i<=9;i++){
            ans=(ans+solve(i,n,dp))%mod;
        }
        return (int)(ans%mod);
    }
    private long solve(int digit,int n,long[][] dp){
        if(n==1)return 1;
        if(dp[digit][n]!=-1)return dp[digit][n];
        long ans=0;
        for(int d:moves[digit]){
           ans=(ans+solve(d,n-1,dp))%mod;
        }
        return dp[digit][n]=ans;
    }
}