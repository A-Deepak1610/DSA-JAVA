class Solution {
    int[] dp;
    int[] prev;
    int mod=(int)1e9+7;
    public int distinctSubseqII(String s) {
        int n=s.length();
        dp=new int[n];
        prev=new int[n];
        int[] last=new int[26];
        Arrays.fill(dp,-1);
        Arrays.fill(prev,-1);
        Arrays.fill(last,-1);
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            prev[i]=last[idx];
            last[idx]=i;
        }
        return ((solve(n-1)-1)+mod)%mod;
    }
    private int solve(int i){
        if(i<0)return 1;
        if(i==0)return 2;
        if(dp[i]!=-1)return dp[i];
        long ans=2L*solve(i-1)%mod;//take + dont take
        if(prev[i]!=-1){
             ans = (ans - solve(prev[i] - 1) + mod) % mod;
        }
        return dp[i]=(int)ans%mod;
    }
}