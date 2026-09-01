class Solution {
    int[] dp;
    public int maxSumIS(int arr[]) {
        int maxSum=0;
        int n=arr.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            int sum=arr[i]+solve(arr,i);
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
    private int solve(int[] nums,int prev){
        if(dp[prev]!=-1)return dp[prev];
        int maxSum=0;
        for(int i=prev+1;i<nums.length;i++){
            if(nums[i]>nums[prev]){
                int sum=nums[i]+solve(nums,i);
                maxSum=Math.max(maxSum,sum);
            }
        }
        return dp[prev]=maxSum;
    }
}