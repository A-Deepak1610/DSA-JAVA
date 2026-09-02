class Solution {
    int[] dp;
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int maxLen=0;
        int n=pairs.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            int len=1+solve(pairs,i);
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }
    private int solve(int[][] nums,int prev){
        if(dp[prev]!=-1)return dp[prev];
        int maxLen=0;
        for(int i=prev+1;i<nums.length;i++){
            if(nums[i][0]>nums[prev][1]){
                int len=1+solve(nums,i);
                maxLen=Math.max(maxLen,len);
            }
        }
        return dp[prev]=maxLen;
    }
}