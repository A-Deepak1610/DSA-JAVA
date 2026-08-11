class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        double[][] dp=new double[nums.length][k+1];
        for(double[] d:dp)Arrays.fill(d,-1);
        return solve(nums,0,k,dp);
    }
    private double solve(int[] nums,int i,int k,double[][] dp){
        if(i==nums.length)return 0;
        if(dp[i][k]!=-1)return dp[i][k];
        if(k==1){
            int sum=0;
            for(int j=i;j<nums.length;j++)sum+=nums[j];
            return (double)sum/(nums.length-i);
        }
        int sum=0;
        double maxAvg=0.0;
        for(int j=i;j<nums.length;j++){
            sum+=nums[j];
            double avg=(double)sum/(j-i+1)+solve(nums,j+1,k-1,dp);
            maxAvg=Math.max(maxAvg,avg);
        }
        return dp[i][k]=maxAvg;
    }
}