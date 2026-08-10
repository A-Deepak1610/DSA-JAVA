class Solution {
    public int maxSumAfterPartitioning(int[] nums, int k) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,k,0,dp);
    }
    private int solve(int[] nums,int k,int idx,int[] dp){
        if(idx==nums.length)return 0;
        if(dp[idx]!=-1)return dp[idx];
        int sum=0,maxElement=-1,maxSum=0; 
        for(int i=idx;i<Math.min(nums.length,idx+k);i++){
            maxElement=Math.max(maxElement,nums[i]);
            sum=maxElement*(i-idx+1)+solve(nums,k,i+1,dp);
            maxSum=Math.max(sum,maxSum);
        }
        return dp[idx]=maxSum;
    }
}