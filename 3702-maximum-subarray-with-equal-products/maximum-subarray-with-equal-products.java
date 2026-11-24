class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            int prod=nums[i];
            int lcm=nums[i],gcd=nums[i];
            for(int j=i+1;j<n;j++){
                prod*=nums[j];
                gcd=gcd(nums[j],gcd);
                lcm=nums[j]*lcm/gcd(lcm,nums[j]);
                if(prod==lcm*gcd)maxLen=Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }
    private int gcd(int a,int b){
        if(b>a)return gcd(b,a);
        if(b==0)return a;
        return gcd(b,a%b);
    }
}