class Solution {
    private static final int MOD = 1_000_000_007;

    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        
        long[][] memoCount = new long[n][n];
        long[][] memoMax = new long[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(memoCount[i], -1);
            Arrays.fill(memoMax[i], -1);
        }
        
        long[] result = solve(grid, 0, 0, memoCount, memoMax);
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add((int) (result[0] % MOD));
        res.add(result[0] == 0 ? 0 : (int) (result[1] % MOD));
        
        return res;
    }
    
    // Returns long[]{pathCount, maxPathSum} for cell (i, j)
    private long[] solve(int[][] grid, int i, int j, long[][] memoCount, long[][] memoMax) {
        int n = grid.length;
        
        // Base Case: Out of bounds
        if (i >= n || j >= n) {
            return new long[]{0, -1};
        }
        
        // Base Case: Reached Destination
        if (i == n - 1 && j == n - 1) {
            return new long[]{1, grid[i][j]};
        }
        
        // Return memoized result if already calculated
        if (memoCount[i][j] != -1) {
            return new long[]{memoCount[i][j], memoMax[i][j]};
        }
        
        int num = grid[i][j];
        long totalWays = 0;
        long maxSubPathSum = -1;
        
        // Move Right (allowed for 1 or 3)
        if (num == 1 || num == 3) {
            long[] right = solve(grid, i, j + 1, memoCount, memoMax);
            if (right[0] > 0) {
                totalWays = (totalWays + right[0]) % MOD;
                maxSubPathSum = Math.max(maxSubPathSum, right[1]);
            }
        }
        
        // Move Down (allowed for 2 or 3)
        if (num == 2 || num == 3) {
            long[] down = solve(grid, i + 1, j, memoCount, memoMax);
            if (down[0] > 0) {
                totalWays = (totalWays + down[0]) % MOD;
                maxSubPathSum = Math.max(maxSubPathSum, down[1]);
            }
        }
        
        // Store results in memo tables
        if (totalWays > 0) {
            memoCount[i][j] = totalWays;
            memoMax[i][j] = grid[i][j] + maxSubPathSum;
        } else {
            memoCount[i][j] = 0;
            memoMax[i][j] = -1;
        }
        
        return new long[]{memoCount[i][j], memoMax[i][j]};
    }
}