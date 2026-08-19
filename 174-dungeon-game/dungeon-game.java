class Solution {
    int m, n;
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(dungeon, 0, 0);
    }
    private int solve(int[][] nums, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - nums[i][j]);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        if(i<m-1)down = solve(nums, i + 1, j);
        if(j<n-1)right = solve(nums, i, j + 1);
        int nextNeed = Math.min(down, right);
        int need = Math.max(1, nextNeed - nums[i][j]);
        return dp[i][j] = need;
    }
}