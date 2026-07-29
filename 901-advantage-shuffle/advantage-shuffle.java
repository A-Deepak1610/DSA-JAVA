class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n=nums1.length;
        Arrays.sort(nums1);
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++)idx[i]=i;
        Arrays.sort(idx,(a,b)->nums2[b]-nums2[a]);
        int[] res=new int[n];
        int l=0,r=n-1;
        for(int i:idx){
            if(nums1[r]>nums2[i]){
                res[i]=nums1[r];
                r--;
            }
            else {
                res[i]=nums1[l++];
            }
        }
        return res;
    }
}