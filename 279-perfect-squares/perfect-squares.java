class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return numSquares(dp,n);
    }
    private int numSquares(int[] dp,int n){
        if(n==0)return 0;
        if(dp[n]!=-1)return dp[n];
        int ans=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            ans=Math.min(ans,1+numSquares(dp,n-i*i));
        }
        dp[n]=ans;
        return dp[n];
    }
}