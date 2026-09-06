class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp=new int[s.length()][t.length()];
        for(int[] d:dp)Arrays.fill(d,-1);
        return solve(s,t,0,0);
    }
    private int solve(String s,String t,int i,int j){
        if(j==t.length())return 1;
        if(i==s.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int count=0;
        if(s.charAt(i)==t.charAt(j))count=solve(s,t,i+1,j+1)+solve(s,t,i+1,j);
        else count=solve(s,t,i+1,j);
        return dp[i][j]=count;
    }
}