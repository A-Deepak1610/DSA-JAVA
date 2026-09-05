class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())return false;
        dp=new Boolean[s1.length()+1][s2.length()+1];
        return solve(s1,s2,s3,0,0);
    }
    private boolean solve(String s1,String s2,String s3,int i,int j){
        if(i+j==s3.length())return true;
        if(dp[i][j]!=null)return dp[i][j];
        char ch=s3.charAt(i+j);
        boolean match=false;
        if(i<s1.length()&&s1.charAt(i)==ch)match=match||solve(s1,s2,s3,i+1,j);
        if(j<s2.length()&&s2.charAt(j)==ch)match=match||solve(s1,s2,s3,i,j+1);
        return dp[i][j]=match;
    }
}