import java.util.Arrays;

class Solution {
    private int mod = (int) 1e9 + 7;
    private int[][] dp;
    public int countVowelPermutation(int n) {
        dp = new int[n + 1][5];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        long ans = 0;
        ans = (ans + solve(n - 1, 'a')) % mod;
        ans = (ans + solve(n - 1, 'e')) % mod;
        ans = (ans + solve(n - 1, 'i')) % mod;
        ans = (ans + solve(n - 1, 'o')) % mod;
        ans = (ans + solve(n - 1, 'u')) % mod;
        return (int) ans;
    }
    private int solve(int rem, char ch) {
        if (rem == 0) {
            return 1;
        }
        int idx = getIndex(ch);
        if (dp[rem][idx] != -1) {
            return dp[rem][idx];
        }
        long ans = 0;
        if (ch == 'a') {
            ans = (ans + solve(rem - 1, 'e')) % mod;
        } else if (ch == 'e') {
            ans = (ans + solve(rem - 1, 'a')) % mod;
            ans = (ans + solve(rem - 1, 'i')) % mod;
        } else if (ch == 'i') {
            ans = (ans + solve(rem - 1, 'a')) % mod;
            ans = (ans + solve(rem - 1, 'e')) % mod;
            ans = (ans + solve(rem - 1, 'o')) % mod;
            ans = (ans + solve(rem - 1, 'u')) % mod;
        } else if (ch == 'o') {
            ans = (ans + solve(rem - 1, 'i')) % mod;
            ans = (ans + solve(rem - 1, 'u')) % mod;
        } else if (ch == 'u') {
            ans = (ans + solve(rem - 1, 'a')) % mod;
        }
        return dp[rem][idx] = (int) ans;
    }
    private int getIndex(char ch) {
        switch (ch) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: return 0;
        }
    }
}