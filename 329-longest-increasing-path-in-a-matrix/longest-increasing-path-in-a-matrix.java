class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int maxLen=1;
        dp=new int[matrix.length][matrix[0].length];
        for(int[] d:dp)Arrays.fill(d,-1);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                maxLen=Math.max(maxLen,dfs(matrix,i,j));
            }
        }
        return maxLen;
    }
    private int dfs(int[][] matrix,int r,int c){
        if(dp[r][c]!=-1)return dp[r][c];
        int n=matrix.length,m=matrix[0].length;
        int maxLen=1;
        if(r-1>=0&&matrix[r][c]<matrix[r-1][c])maxLen=Math.max(maxLen,1+dfs(matrix,r-1,c));
        if(r+1<n&&matrix[r][c]<matrix[r+1][c])maxLen=Math.max(maxLen,1+dfs(matrix,r+1,c));
        if(c-1>=0&&matrix[r][c]<matrix[r][c-1])maxLen=Math.max(maxLen,1+dfs(matrix,r,c-1));
        if(c+1<m&&matrix[r][c]<matrix[r][c+1])maxLen=Math.max(maxLen,1+dfs(matrix,r,c+1));
        return dp[r][c]=maxLen;
    }
}