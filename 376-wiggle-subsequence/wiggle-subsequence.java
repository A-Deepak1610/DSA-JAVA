class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int count = 1;
        int prevDiff = 0;
        for (int i = 1; i < n; i++) {
            int currDiff = nums[i] - nums[i - 1];
            if ((currDiff > 0 && prevDiff <= 0) || 
                (currDiff < 0 && prevDiff >= 0)) {
                count++;
                prevDiff = currDiff;
            }
        }
        return count;
    }
}