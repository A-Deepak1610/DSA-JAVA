class Solution {
    public int findMin(int[] nums) {
        int n=nums.length,l=0,r=n-1,ans=Integer.MAX_VALUE;
        if(n==1)return nums[0];
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[l]<=nums[mid]){
                ans=Math.min(ans,nums[l]);
                l=mid+1;
            }
            else{
                ans=Math.min(ans,nums[mid]);
                r=mid-1;
            }
        }
        return ans;
    }
}