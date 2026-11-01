class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        dist[0][0] = 0;
        dq.addFirst(new int[]{0, 0, 0});
        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int r = curr[0], c = curr[1], d = curr[2];
            if (d != dist[r][c]) continue;
            if (r == m-1 && c == n-1)
                return d;
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;
                int cost = (grid[r][c] == i+1) ? 0 : 1;
                if (d + cost < dist[nr][nc]) {
                    dist[nr][nc] = d + cost;
                    if (cost == 0)
                        dq.addFirst(new int[]{nr, nc, d});
                    else
                        dq.addLast(new int[]{nr, nc, d+1});
                }
            }
        }
        return -1;
    }
}