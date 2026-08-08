class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(freq.keySet());
        Collections.sort(values);
        int[] dp = new int[values.size()];
        Arrays.fill(dp, -1);
        return solve(values, freq, 0, dp);
    }

    private int solve(List<Integer> values, Map<Integer, Integer> freq, int i, int[] dp) {
        if (i >= values.size()) {
            return 0;
        }
        if (dp[i] != -1)
            return dp[i];
        int current = values.get(i);
        int skip = solve(values, freq, i + 1, dp);
        int points = current * freq.get(current);
        int nextIndex;
        if (i + 1 < values.size() && values.get(i + 1) == current + 1) {
            nextIndex = i + 2;
        } else {
            nextIndex = i + 1;
        }
        int take = points + solve(values, freq, nextIndex, dp);
        return dp[i] = Math.max(take, skip);
    }
}