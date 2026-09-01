class Solution {
    int[] dp;
    int[] count;
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        count=new int[n];
        Arrays.fill(dp,-1);
        int maxLen=0;
        for(int i=0;i<n;i++){
            solve(nums,i);
            maxLen=Math.max(maxLen,dp[i]);
        }
        int lis=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxLen){
                lis+=count[i];
            }
        }
        return lis;
    }
    private void solve(int[] nums,int prev){
        if(dp[prev]!=-1)return ;
        dp[prev]=1;
        count[prev]=1;
        for(int i=prev+1;i<nums.length;i++){
            if(nums[i]>nums[prev]){
                solve(nums,i);
                if(dp[i]+1>dp[prev]){
                    dp[prev]=dp[i]+1;
                    count[prev]=count[i];
                }
                else if(dp[i]+1==dp[prev]){
                    count[prev]+=count[i];
                }                
            }
        }

    }
}