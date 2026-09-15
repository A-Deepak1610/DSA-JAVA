class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        int i=0,j=0;
        long sum1=0,sum2=0;
        while(i<n1&&j<n2){
            if(nums1[i]<nums2[j])sum1+=nums1[i++];
            else if(nums2[j]<nums1[i])sum2+=nums2[j++];
            else{
                sum1=sum2=nums1[i]+Math.max(sum1,sum2);
                i++;
                j++;
            }
        }
        while(i<n1)sum1+=nums1[i++];
        while(j<n2)sum2+=nums2[j++];
        return (int)(Math.max(sum1,sum2)%1_000_000_007);
    }
}