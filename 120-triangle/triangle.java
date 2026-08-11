class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp=new Integer[triangle.size()][triangle.size()];
        return minimumTotal(triangle,0,0,dp);
    }
    private int minimumTotal(List<List<Integer>> triangle,int i,int j,Integer[][] dp){
        if(i==triangle.size())return 0;
        if(dp[i][j]!=null)return dp[i][j];
        int s1=triangle.get(i).get(j)+minimumTotal(triangle,i+1,j,dp);
        int s2=triangle.get(i).get(j)+minimumTotal(triangle,i+1,j+1,dp);
        return dp[i][j]=Math.min(s1,s2);
    }
}