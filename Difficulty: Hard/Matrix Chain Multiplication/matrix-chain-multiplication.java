class Solution {
    static int[][] dp;
    static int matrixMultiplication(int arr[]) {
        dp=new int[arr.length][arr.length];
        for(int[] d:dp)Arrays.fill(d,-1);
        return solve(arr,1,arr.length-1);
    }
    static int solve(int[] arr,int i,int j){
        if(i==j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int minOps=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int ops=arr[i-1]*arr[k]*arr[j]+solve(arr,i,k)+solve(arr,k+1,j);
            minOps=Math.min(minOps,ops);
        }
        return dp[i][j]=minOps;
    }
}