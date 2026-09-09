class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = n;
            }
        }
        for (int[] mine : mines) {
            dp[mine[0]][mine[1]] = -1;
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) {
                    count = 0;
                } else {
                    count++;
                    dp[i][j] = count;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] == -1) {
                    count = 0;
                } else {
                    count++;
                    dp[i][j] = Math.min(dp[i][j], count);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (dp[i][j] == -1) {
                    count = 0;
                } else {
                    count++;
                    dp[i][j] = Math.min(dp[i][j], count);
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (dp[i][j] == -1) {
                    count = 0;
                } else {
                    count++;
                    dp[i][j] = Math.min(dp[i][j], count);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}