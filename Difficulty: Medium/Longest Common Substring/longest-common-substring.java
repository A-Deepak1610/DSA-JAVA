class Solution {
    public int longCommSubstr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        Integer[][] dp = new Integer[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, solve(s1, s2, i, j, dp));
            }
        }
        return ans;
    }
    private int solve(String s1, String s2,
                      int i, int j,
                      Integer[][] dp) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s1.charAt(i) != s2.charAt(j)) {
            return dp[i][j] = 0;
        }
        return dp[i][j] =
                1 + solve(s1, s2, i + 1, j + 1, dp);
    }
}