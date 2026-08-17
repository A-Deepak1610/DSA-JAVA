class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d)return -1;
        int[][] dp=new int[jobDifficulty.length][d+1];
        for(int[] days:dp)Arrays.fill(days,-1);
        return solve(jobDifficulty,0,d,dp);
    }
    private int solve(int[] nums,int idx,int d,int[][] dp){
        int max=0,ans=Integer.MAX_VALUE;
        if(dp[idx][d]!=-1)return dp[idx][d];
        if(d==1){
            for(int i=idx;i<nums.length;i++)max=Math.max(max,nums[i]);
            return max;
        }
        for(int i=idx;i<=nums.length-d;i++){
            max=Math.max(nums[i],max);
            ans=Math.min(ans,max+solve(nums,i+1,d-1,dp));
        }
        return dp[idx][d]=ans;
    }
}