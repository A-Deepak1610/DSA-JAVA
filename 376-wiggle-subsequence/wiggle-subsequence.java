class Solution {
    public int wiggleMaxLength(int[] nums) {

        int n = nums.length;

        if (n < 2) {
            return n;
        }

        int count = 1;

        // previous difference
        int prevDiff = 0;

        for (int i = 1; i < n; i++) {

            // current difference
            int currDiff = nums[i] - nums[i - 1];

            // If direction changes
            if ((currDiff > 0 && prevDiff <= 0) || 
                (currDiff < 0 && prevDiff >= 0)) {

                count++;

                // update previous direction
                prevDiff = currDiff;
            }
        }

        return count;
    }
}