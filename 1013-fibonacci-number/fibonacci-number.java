class Solution {
    public int fib(int n) {//tabulation
    if(n==1||n==0)return n;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
// class Solution {
//     public int fib(int n) {//memorization
//         int[] dp=new int[n+1];
//         Arrays.fill(dp,-1);
//         return fib(n,dp);
//     }
//     private int fib(int n,int[] dp){
//         if(n<=1)return n;
//         if(dp[n]!=-1)return dp[n];
//         dp[n]=fib(n-1,dp)+fib(n-2,dp);
//         return dp[n];
//     }
// }