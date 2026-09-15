class Solution {
    boolean[][] pal;
    int[] dp;
    int n;
    public int maxPalindromes(String s, int k) {
        n=s.length();
        dp=new int[n];
        pal=new boolean[n][n];
        Arrays.fill(dp,-1);
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=2||pal[i+1][j-1])pal[i][j]=true;
                }
            }
        }
        return solve(s,k,0);
    }
    private int solve(String s,int k,int st){
        if(st>=n)return 0;
        if(dp[st]!=-1)return dp[st];
        int skip=solve(s,k,st+1);
        int take=0;
        for(int j=st+k-1;j<n;j++){
            if(pal[st][j])take=Math.max(take,1+solve(s,k,j+1));
        }
        return dp[st]=Math.max(skip,take);
    }
}