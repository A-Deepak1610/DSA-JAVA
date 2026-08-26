class Solution {
    int[][] dp;
    public int minDistance(String w1, String w2) {
        dp=new int[w1.length()][w2.length()];
        for(int[] d:dp)Arrays.fill(d,-1);
        return solve(w1,w2,0,0);
    }
    private int solve(String w1,String w2,int i,int j){
        if(i==w1.length())return w2.length()-j;
        if(j==w2.length())return w1.length()-i;
        int minOps=Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)){
            minOps=Math.min(minOps,solve(w1,w2,i+1,j+1));
        }
        else{
            minOps=Math.min(minOps,1+solve(w1,w2,i,j+1));//insert
            minOps=Math.min(minOps,1+solve(w1,w2,i+1,j));//delete
            minOps=Math.min(minOps,1+solve(w1,w2,i+1,j+1));//replace
        }
        return dp[i][j]=minOps;
    }
}