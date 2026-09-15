class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n=nums.length;
        dp=new int[n+2][n+2];
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++)arr[i+1]=nums[i];
        for(int[] d:dp)Arrays.fill(d,-1);
        return solve(arr,0,n+1);
    }
    private int solve(int[] nums,int i,int j){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int maxCoins=0;
        for(int k=i+1;k<j;k++){
            int coins=nums[i]*nums[k]*nums[j]+solve(nums,i,k)+solve(nums,k,j);
            maxCoins=Math.max(maxCoins,coins);
        }
        return dp[i][j]=maxCoins;
    }
}