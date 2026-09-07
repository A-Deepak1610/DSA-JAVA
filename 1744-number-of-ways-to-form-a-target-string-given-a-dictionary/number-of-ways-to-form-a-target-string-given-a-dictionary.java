class Solution {
    int[][] freq;
    int[][] dp;
    int mod = (int) 1e9 + 7;
    String target;
    public int numWays(String[] words, String target) {
        this.target = target;
        int n = words.length;
        int L = words[0].length();
        int M = target.length();
        freq = new int[L][26];
        for (String word : words) {
            for (int i = 0; i < L; i++) {
                freq[i][word.charAt(i) - 'a']++;
            }
        }
        dp = new int[L][M];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0);
    }
    private int solve(int k, int j) {
        if (j == target.length()) {
            return 1;
        }
        if (k == freq.length) {
            return 0;
        }
        if (dp[k][j] != -1) {
            return dp[k][j];
        }
        long ans = 0;
        for (int i = k; i < freq.length; i++) {
            int count = freq[i][target.charAt(j) - 'a'];
            if (count > 0) {
                ans += (long) count * solve(i + 1, j + 1);
                ans %= mod;
            }
        }
        return dp[k][j] = (int) ans;
    }
}