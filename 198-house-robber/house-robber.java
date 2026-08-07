class Solution {
    int maxCost=0;
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return rob(nums,0,dp);
    }
    private int  rob(int[] nums,int st,int[] dp){
        if(st>=nums.length){
            return 0;
        }
        if(dp[st]!=-1)return dp[st];
        int c1=rob(nums,st+2,dp)+nums[st];
        int c2=rob(nums,st+1,dp);
        return dp[st]=Math.max(c1,c2);
    }
}