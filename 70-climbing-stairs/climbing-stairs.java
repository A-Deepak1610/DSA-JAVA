class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return climbStairs(n,dp);
    }
    private int climbStairs(int n,int[] dp){
        if(n==0||n==1)return 1;
        if(dp[n]!=-1)return dp[n];
        dp[n]=climbStairs(n-1,dp)+climbStairs(n-2,dp);
        return dp[n];
    }
}
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Recursion       : " + recursion(n));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Memoization     : " + memoization(n, dp));
        System.out.println("Tabulation      : " + tabulation(n));
        System.out.println("Space Optimized : " + spaceOptimized(n));
    }
    // -------------------------------------------------
    // 1. Pure Recursion
    // Time : O(2^n)
    // Space : O(n)
    // -------------------------------------------------
    static int recursion(int n) {
        if (n == 0 || n == 1)
            return 1;
        return recursion(n - 1) + recursion(n - 2);
    }
    // -------------------------------------------------
    // 2. Memoization (Top Down)
    // Time : O(n)
    // Space : O(n)
    // -------------------------------------------------
    static int memoization(int n, int[] dp) {
        if (n == 0 || n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
        return dp[n];
    }
    // ------------------------------------------------
    // 3. Tabulation (Bottom Up)
    // Time : O(n)
    // Space : O(n)
    // ------------------------------------------------
    static int tabulation(int n) {
        if (n == 0 || n == 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    // -------------------------------------------------
    // 4. Space Optimized
    // Time : O(n)
    // Space : O(1)
    // -------------------------------------------------
    static int spaceOptimized(int n) {
        if (n == 0 || n == 1)
            return 1;
        int prev2 = 1; // dp[0]
        int prev1 = 1; // dp[1]
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}