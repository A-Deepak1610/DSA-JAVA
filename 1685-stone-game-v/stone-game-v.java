class Solution {
    int[][] sum;
    int[][] dp;
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        sum=new int[n][n];
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            sum[i][i]=stoneValue[i];
            for(int j=i+1;j<n;j++){
                sum[i][j]=sum[i][j-1]+stoneValue[j];
            }   
            Arrays.fill(dp[i],-1);
        }
        return solve(stoneValue,0,n-1);
    }
    private int solve(int[] stoneValue,int i,int j){
        int maxScore=0;
        if(i==j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        for(int k=i;k<j;k++){
            int left=sum[i][k];
            int right=sum[k+1][j];
            if(left>right){
               int score=right+solve(stoneValue,k+1,j);
               maxScore=Math.max(score,maxScore);
            }
            else if(right>left){
               int score=left+solve(stoneValue,i,k);
               maxScore=Math.max(score,maxScore);
            }
            else{
                int leftScore=left+solve(stoneValue,k+1,j);
                int rightScore=right+solve(stoneValue,i,k);
                maxScore=Math.max(maxScore,Math.max(leftScore,rightScore));
            }
        }
        return dp[i][j]=maxScore;
    }
}