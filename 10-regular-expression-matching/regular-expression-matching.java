class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        dp=new Boolean[s.length()+1][p.length()+1];
        return solve(s,p,0,0);
    }
    private boolean solve(String s,String p,int i,int j){
        if(j==p.length())return i==s.length();
        if(dp[i][j]!=null)return dp[i][j];
        boolean match=i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.');
        if((j+1)<p.length()&&p.charAt(j+1)=='*'){
            return dp[i][j]=solve(s,p,i,j+2)||match&&solve(s,p,i+1,j);
        }
        else return dp[i][j]=match&&solve(s,p,++i,++j);
    }
}