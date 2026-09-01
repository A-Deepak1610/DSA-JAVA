class Solution {
    int[] dp;
    int[] next;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> lds=new ArrayList<>();
        int n=nums.length;
        dp=new int[n];
        next=new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp,-1);
        Arrays.fill(next,-1);
        int st=-1,maxLen=0;
        for(int i=0;i<n;i++){
            int len=solve(nums,i);
            if(len>maxLen){
                st=i;
                maxLen=len;
            }
        }
        while(st!=-1){
            lds.add(nums[st]);
            st=next[st];
        }
        return lds;
    }
    private int solve(int[] nums,int prev){
        if(dp[prev]!=-1)return dp[prev];
        int maxLen=1;
        for(int i=prev+1;i<nums.length;i++){
            if(nums[i]%nums[prev]==0){
                int len=1+solve(nums,i);
                if(len>maxLen){
                    maxLen=len;
                    next[prev]=i;
                }
            }
        }
        return dp[prev]=maxLen;
    }
}