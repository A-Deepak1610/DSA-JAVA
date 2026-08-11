class Solution {
    static Boolean[][] dp;
    static boolean isSubsetSum(int nums[], int sum) {
        dp=new Boolean[nums.length][sum+1];
        return isSubsetSum(nums,0,sum,dp);
    }
    private static boolean isSubsetSum(int[] nums,int idx,int k,Boolean[][] dp){
        if(k==0)return true;
        if(idx==nums.length||k<0)return false;
        if(dp[idx][k]!=null)return dp[idx][k];
        boolean take=isSubsetSum(nums,idx+1,k-nums[idx],dp);
        boolean notTake=isSubsetSum(nums,idx+1,k,dp);
        return dp[idx][k]=take||notTake;
    }
}