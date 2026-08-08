class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[days.length];
        Arrays.fill(dp,-1);
        return minCost(days, costs, 0,dp);
    }

    private int minCost(int[] days, int[] cost, int st,int[] dp) {
        if (st >= days.length)
            return 0;
        if(dp[st]!=-1)return dp[st];
        int i1 = bs(days, days[st] + 6);
        int i2 = bs(days, days[st] + 29);
        int c1 = cost[0] + minCost(days, cost, st + 1,dp);
        int c2 = cost[1] + minCost(days, cost,i1+1,dp);
        int c3 = cost[2] + minCost(days, cost,i2+1,dp);
        return dp[st]=Math.min(c1, Math.min(c2, c3));
    }

    private int bs(int[] nums, int k) {
        int idx = 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= k) {
                idx = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return idx;
    }
}