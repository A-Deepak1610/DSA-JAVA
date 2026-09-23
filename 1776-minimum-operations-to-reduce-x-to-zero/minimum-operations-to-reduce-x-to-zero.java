class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int num:nums)sum+=num;
        int target=sum-x;
        int l=0,maxLen=0;
        if(target==0)return nums.length;
        sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(l<nums.length&&sum>target)sum-=nums[l++];
            if(sum==target)maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen==0?-1:nums.length-maxLen;
    }
}