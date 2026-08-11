class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums)sum+=num;
        if(sum%2!=0)return false;
        Boolean[][] dp=new Boolean[nums.length][sum/2+1];
        return isSubsetSum(nums,0,sum/2,dp);
    }
    private boolean isSubsetSum(int[] nums,int idx,int k,Boolean[][] dp){
        if(k==0)return true;
        if(idx==nums.length||k<0)return false;
        if(dp[idx][k]!=null)return dp[idx][k];
        boolean take=isSubsetSum(nums,idx+1,k-nums[idx],dp);
        boolean notTake=isSubsetSum(nums,idx+1,k,dp);
        return dp[idx][k]=take||notTake;
    }
}