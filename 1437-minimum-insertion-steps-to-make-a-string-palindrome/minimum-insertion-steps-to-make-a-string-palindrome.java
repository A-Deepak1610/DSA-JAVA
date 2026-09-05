class Solution {
    int[][] dp;
    public int minInsertions(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        int lcs=lcs(s,rev);
        return s.length()-lcs;
    }
    public int lcs(String t1, String t2) {
        dp=new int[t1.length()][t2.length()];
        for(int[] d:dp)Arrays.fill(d,-1);
        return solve(t1,t2,0,0);
    }
    private int solve(String t1,String t2,int i,int j){
        if(i>=t1.length()||j>=t2.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int maxLen=0;
        if(t1.charAt(i)==t2.charAt(j))maxLen=Math.max(maxLen,1+solve(t1,t2,i+1,j+1));
        else{
            maxLen=Math.max(maxLen,Math.max(solve(t1,t2,i+1,j),solve(t1,t2,i,j+1)));
        }
        return dp[i][j]=maxLen;
    }
}