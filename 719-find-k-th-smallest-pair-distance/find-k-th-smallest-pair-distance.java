class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0,r=nums[nums.length-1]-nums[0];
        int diff=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(countPair(nums,mid)>=k){
                diff=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return diff;
    }
    private int countPair(int[] arr,int k){
        int  left=0,count=0;
        for(int right=0;right<arr.length;right++){
            while(arr[right]-arr[left]>k)left++;
            count+=right-left;
        }    
        return count;
    }
}