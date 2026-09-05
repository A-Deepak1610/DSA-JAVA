class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s1, String s2) {
        dp=new Boolean[s1.length()+1][s2.length()+1];
        return solve(s1,s2,0,0);
    }
    private boolean solve(String s1,String s2,int i,int j){
        if(i==s1.length()){
            while (j < s2.length()) {
                if (s2.charAt(j) != '*')
                    return false;
                j++;
            }
            return true;
        }
        if(dp[i][j]!=null)return dp[i][j];
        boolean match=false;
        if(j<s2.length()&&s2.charAt(j)=='*'){
            match=solve(s1,s2,i+1,j)||solve(s1,s2,i,j+1);
        }
        else if(j<s2.length()){
            match=s1.charAt(i)==s2.charAt(j)||s2.charAt(j)=='?';
            return dp[i][j]=match&&solve(s1,s2,i+1,j+1);
        }
        return dp[i][j]=match;
    }
}