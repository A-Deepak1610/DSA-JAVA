class Solution {
    public long maximumTotalDamage(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(freq.keySet());
        Collections.sort(values);
        long[] dp = new long[values.size()];
        Arrays.fill(dp, -1);
        return solve(values, freq, 0, dp);
    }

    private long solve(List<Integer> values, Map<Integer, Integer> freq, int i, long[] dp) {
        if (i >= values.size()) {
            return 0;
        } 
        if (dp[i] != -1)
            return dp[i];
        int current = values.get(i);
        long skip = solve(values, freq, i + 1, dp);
        long points = (long)current * freq.get(current);
        int nextIndex;
        if (i + 1 < values.size() && values.get(i + 1) <= current + 2) {
            nextIndex = i + 1;
            while (nextIndex < values.size() &&
                values.get(nextIndex) <= current + 2) {
                nextIndex++;
            }
        } else {
            nextIndex = i + 1;
        }
        long take = points + solve(values, freq, nextIndex, dp);
        return dp[i] = Math.max(take, skip);
    }
}