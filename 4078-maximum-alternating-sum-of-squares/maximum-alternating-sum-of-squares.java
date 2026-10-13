class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)nums[i]=Math.abs(nums[i]);
        Arrays.sort(nums);
        int maxN=(int)Math.ceil(n/2f);
        int minN=n-maxN;
        long maxSum=0,minSum=0;
        for(int i=0;i<minN;i++)minSum+=nums[i]*nums[i];
        for(int i=minN;i<n;i++)maxSum+=nums[i]*nums[i];
        return maxSum-minSum;
    }
}