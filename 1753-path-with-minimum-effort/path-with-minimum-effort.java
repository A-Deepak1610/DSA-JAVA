class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], effort = curr[2];
            if (effort > dist[r][c]) continue;
            if (r == m - 1 && c == n - 1) {
                return effort;
            }
            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int heightDiff =
                        Math.abs(heights[nr][nc] - heights[r][c]);
                    int newEffort = Math.max(effort, heightDiff);
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new int[]{nr, nc, newEffort});
                    }
                }
            }
        }
        return 0;
    }
}