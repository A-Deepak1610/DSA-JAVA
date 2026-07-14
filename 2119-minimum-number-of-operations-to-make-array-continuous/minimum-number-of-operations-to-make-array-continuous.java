class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length,m=0;
        Arrays.sort(nums);
        int[] unique=new int[n];
        for(int i=0;i<n;i++){
            if (i==0||nums[i]!=nums[i-1]){
                unique[m++]=nums[i];
            }
        }
        int j=0;
        int ops=n;
        for(int i=0;i<m;i++){
            int maxVal=unique[i]+n-1;
            while(j<m&&unique[j]<=maxVal)j++;
            ops=Math.min(ops,n-(j-i));
        }
        return ops;
    }
}