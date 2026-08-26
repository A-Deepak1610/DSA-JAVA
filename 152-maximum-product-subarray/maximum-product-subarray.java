class Solution {
    public int maxProduct(int[] nums) {
        int prefix=1,sufix=1;
        int n=nums.length;
        int maxProduct=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix==0)prefix=1;
            if(sufix==0)sufix=1;
            prefix*=nums[i];
            sufix*=nums[n-1-i];
            maxProduct=Math.max(maxProduct,Math.max(prefix,sufix));
        }
        return maxProduct;
    }
}