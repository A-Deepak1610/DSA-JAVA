class Solution {
    int[][] max; 
    int[][] dp;
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
         max=new int[n][n];
         dp=new int[n][n];
        for(int i=0;i<n;i++){
            max[i][i]=arr[i];
            for(int j=i+1;j<n;j++){
                max[i][j]=Math.max(max[i][j-1],arr[j]);
            }
            Arrays.fill(dp[i],-1);
        }
        return solve(arr,0,n-1);
    }
    private int solve(int[] arr,int i,int j){
        if(i==j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int minVal=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int val=max[i][k]*max[k+1][j]+solve(arr,i,k)+solve(arr,k+1,j);
            minVal=Math.min(minVal,val);
        }
        return dp[i][j]=minVal;
    }
}