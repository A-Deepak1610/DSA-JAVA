class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0,r=0;
        for(int n:nums){
            l=Math.max(l,n);
            r+=n;
        }
        int ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(countSplit(nums,mid)<=k){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
       }
       return ans;
    }
    private int countSplit(int[] arr,int k){
        int split=1,sum=0;
        for(int n:arr){ 
            if(sum+n<=k){
                sum+=n;
            }
            else{
                sum=n;
                split++;
            }
        }
        return split;
    }
}