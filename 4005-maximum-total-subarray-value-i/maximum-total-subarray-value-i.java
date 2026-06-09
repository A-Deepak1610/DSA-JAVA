class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max=Integer.MIN_VALUE;
        long min=Integer.MAX_VALUE;
        for(int n:nums){
            max=Math.max(max,n);
            min=Math.min(min,n);
        }
        return (max-min)*k;
    }
}