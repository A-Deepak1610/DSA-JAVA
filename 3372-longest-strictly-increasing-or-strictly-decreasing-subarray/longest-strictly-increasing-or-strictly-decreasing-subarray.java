class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLenI=1,maxLenD=1;
        int len=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1])len++;
            else len=1;
            maxLenI=Math.max(maxLenI,len);
        }
        len=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1])len++;
            else len=1;
            maxLenD=Math.max(maxLenD,len);
        }
        return Math.max(maxLenD,maxLenI);
    }
}