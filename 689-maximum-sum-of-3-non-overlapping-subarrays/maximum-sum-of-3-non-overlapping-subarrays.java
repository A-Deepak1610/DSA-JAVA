class Solution {
    int[] windowSum;
    int[][] dp;
    boolean[][] choice;
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n=nums.length;
        windowSum=new int[n-k+1];
        dp=new int[n][4];
        choice=new boolean[n][4];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(i>=k)sum-=nums[i-k];
            if(i>=k-1)windowSum[i-k+1]=sum;
        }
        for(int[] d:dp)Arrays.fill(d,-1);
        solve(nums,k,0,3);
        int idx=0;
        int count=3,pos=0;
        int[] res=new int[3];
        while(idx<n){
            if(choice[idx][count]){
                res[pos++]=idx;
                count--;
                idx+=k;
            }
            else idx++;
        }
        return res;
    }
    private int solve(int[] nums,int k,int idx,int count){
        if(count==0)return 0;
        if(idx>=windowSum.length)return Integer.MIN_VALUE/2;
        if(dp[idx][count]!=-1)return dp[idx][count];
        int take=windowSum[idx]+solve(nums,k,idx+k,count-1);
        int skip=solve(nums,k,idx+1,count);
        if(take>=skip){
            dp[idx][count]=take;
            choice[idx][count]=true;
        }
        else{
            dp[idx][count]=skip;
            choice[idx][count]=false;
        }
        return dp[idx][count];
    }
}