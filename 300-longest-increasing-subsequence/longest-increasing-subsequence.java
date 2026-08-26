class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int maxLen=0;
        int n=nums.length;
        dp=new int[n][n];
        for(int[] d:dp)Arrays.fill(d,-1);
        for(int i=0;i<nums.length;i++){
            maxLen=Math.max(maxLen,1+solve(nums,i+1,i));
        }
        return maxLen;
    }
    private int solve(int[] nums,int st,int prev){
        if(st>=nums.length)return 0;
        if(dp[st][prev]!=-1)return dp[st][prev];
        int len=0,maxLen=0;
        for(int i=st;i<nums.length;i++){
            if(nums[i]>nums[prev]){
                maxLen=Math.max(maxLen,1+solve(nums,i+1,i));
            }
        }
        return dp[st][prev]=maxLen;
    }
}