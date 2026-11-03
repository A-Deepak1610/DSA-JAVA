class Solution {
    int[][] overlap;
    int[][] dp;
    int[][] choice;
    int n;
    public String shortestSuperstring(String[] words) {
        n = words.length;
        overlap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int len = Math.min(words[i].length(),
                                   words[j].length());
                for (int k = len; k > 0; k--) {
                    if (words[i].endsWith(
                            words[j].substring(0, k))) {
                        overlap[i][j] = k;
                        break;
                    }
                }
            }
        }
        int totalMasks = 1 << n;
        dp = new int[totalMasks][n];
        choice = new int[totalMasks][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int[] row : choice) {
            Arrays.fill(row, -1);
        }
        int best = -1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int score = solve(1 << i, i);
            if (score > best) {
                best = score;
                start = i;
            }
        }
        StringBuilder sb = new StringBuilder(words[start]);
        int mask = 1 << start;
        int last = start;
        while (mask != totalMasks - 1) {
            int next = choice[mask][last];
            sb.append(words[next].substring(overlap[last][next]));
            mask |= (1 << next);
            last = next;
        }
        return sb.toString();
    }
    int solve(int mask, int last) {
        if (mask == (1 << n) - 1) {
            return 0;
        }
        if (dp[mask][last] != -1) {
            return dp[mask][last];
        }
        int ans = -1;
        for (int next = 0; next < n; next++) {
            if ((mask & (1 << next)) != 0) {
                continue;
            }
            int newMask = mask | (1 << next);
            int currOverlap = overlap[last][next];
            int remaining = solve(newMask, next);
            int total = currOverlap + remaining;
            if (total > ans) {
                ans = total;
                choice[mask][last] = next;
            }
        }
        return dp[mask][last] = ans;
    }
}
