class Solution {
    int[] dp;
    int[] next;
    public ArrayList<Integer> getLIS(int arr[]) {
        ArrayList<Integer> lis=new ArrayList<>();
        int st=-1;
        dp=new int[arr.length];
        next=new int[arr.length];
        Arrays.fill(dp,-1);
        Arrays.fill(next,-1);
        int maxLen=0;
        for(int i=0;i<arr.length;i++){
            int len=1+solve(arr,i);
            if(len>maxLen){
                maxLen=len;
                st=i;
            }
        }
        while(st!=-1){
            lis.add(arr[st]);
            st=next[st];
        }
        return lis;
    }
    private int solve(int[] nums,int prev){
        if(dp[prev]!=-1)return dp[prev];
        int maxLen=0;
        for(int i=prev+1;i<nums.length;i++){
            if(nums[i]>nums[prev]){
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
