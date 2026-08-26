class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int maxLen=0;
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<nums.length;i++){
            maxLen=Math.max(maxLen,1+solve(nums,i));
        }
        return maxLen;
    }
    private int solve(int[] nums,int prev){
        if(dp[prev]!=-1)return dp[prev];
        int len=0,maxLen=0;
        for(int i=prev+1;i<nums.length;i++){
            if(nums[i]>nums[prev]){
                maxLen=Math.max(maxLen,1+solve(nums,i));
            }
        }
        return dp[prev]=maxLen;
        }
}