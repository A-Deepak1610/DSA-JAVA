class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 1;
        Integer[][] dp = new Integer[nums.length][1001];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[i] - nums[j] + 500;
                ans = Math.max(ans, 2 + solve(nums, j, diff, dp));
            }
        }
        return ans;
    }

    private int solve(int[] nums, int index, int diff, Integer[][] dp) {
        int best = 0;
        if (dp[index][diff] != null)
            return dp[index][diff];
        for (int k = index + 1; k < nums.length; k++) {
            if (nums[index] - nums[k] + 500 == diff) {
                best = Math.max(
                        best,
                        1 + solve(nums, k, diff, dp));
            }
        }
        return dp[index][diff] = best;
    }
}