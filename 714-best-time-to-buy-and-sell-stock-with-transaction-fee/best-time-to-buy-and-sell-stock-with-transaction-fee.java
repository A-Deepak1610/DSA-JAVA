class Solution {
    int fee;
    public int maxProfit(int[] prices, int fee) {
        this.fee=fee;
     Integer[][] dp = new Integer[prices.length][2];
        return solve(prices, 0, 1, dp);
    }
    private int solve(int[] prices, int index, int canBuy, Integer[][] dp) {
        if (index == prices.length) {
            return 0;
        }
        if (dp[index][canBuy] != null) {
            return dp[index][canBuy];
        }
        int profit;
        if (canBuy == 1) {
            int buy = -prices[index]
                    + solve(prices, index + 1, 0, dp);
            int skip = solve(prices, index + 1, 1, dp);
            profit = Math.max(buy, skip);

        } else {
            int sell = prices[index]
                    + solve(prices, index + 1, 1, dp)-fee;
            int skip = solve(prices, index + 1, 0, dp);
            profit = Math.max(sell, skip);
        }
        dp[index][canBuy] = profit;
        return profit;
    }
}