 class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, solve(i, arr, difference, dp, lastIndexMap));
            lastIndexMap.put(arr[i], i);
        }
        return maxLen;
    }
    private int solve(int i, int[] arr, int diff, int[] dp, Map<Integer, Integer> lastIndexMap) {
        if (dp[i] != -1) return dp[i];
        int target = arr[i] - diff;
        int best = 1;
        if (lastIndexMap.containsKey(target)) {
            int prevIndex = lastIndexMap.get(target);
            best = 1 + solve(prevIndex, arr, diff, dp, lastIndexMap);
        }
        return dp[i] = best;
    }
}