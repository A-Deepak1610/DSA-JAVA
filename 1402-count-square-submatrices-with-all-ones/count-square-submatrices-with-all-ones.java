class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] dp=new int[m][n];
        int total=0;
        for(int i=0;i<m;i++){
            total+=matrix[i][0];
            dp[i][0]=matrix[i][0];
        }
        for(int j=1;j<n;j++){
            total+=matrix[0][j];
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==1){
                    int count=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    dp[i][j]=count;
                    total+=count;
                }
            }
        }
        return total;
    }
}