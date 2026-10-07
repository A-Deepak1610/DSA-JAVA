class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) return 0;
        int targetMask = (1 << n) - 1; 
        boolean[][] visited = new boolean[n][1 << n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            queue.offer(new int[]{i, mask, 0});
            visited[i][mask] = true;
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int u = current[0];
            int mask = current[1];
            int dist = current[2];
            if (mask == targetMask) {
                return dist;
            }
            for (int neighbor : graph[u]) {
                int nextMask = mask | (1 << neighbor);
                if (!visited[neighbor][nextMask]) {
                    visited[neighbor][nextMask] = true;
                    queue.offer(new int[]{neighbor, nextMask, dist + 1});
                }
            }
        }

        return 0;
    }
}