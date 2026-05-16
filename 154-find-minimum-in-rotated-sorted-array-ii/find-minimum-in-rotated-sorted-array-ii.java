class Solution {
    public int findMin(int[] nums) {
        int n=nums.length,l=0,r=n-1;
        if(n==1)return nums[0];
        int min=Integer.MAX_VALUE;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[l]==nums[mid]&&nums[mid]==nums[r]){
                min=Math.min(min,nums[mid]);
                l++;
                r--;
                continue;
            }
            if(nums[l]<=nums[mid]){
                min=Math.min(min,nums[l]);
                l=mid+1;
            }
            else {
                min=Math.min(min,nums[mid]);
                r=mid-1;
            }
        }
        return min;
    }
}