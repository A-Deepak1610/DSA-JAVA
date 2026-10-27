class Solution {
    int MOD = 1_000_000_007;
    int[] dist, dp;
    List<int[]>[] graph;
    public int countRestrictedPaths(int n, int[][] edges) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];
            if (d > dist[node]) continue;
            for (int[] next : graph[node]) {
                int neighbor = next[0], weight = next[1];
                if (dist[neighbor] > d + weight) {
                    dist[neighbor] = d + weight;
                    pq.offer(new int[]{neighbor, dist[neighbor]});
                }
            }
        }
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(1);
    }
    private int dfs(int node) {
        if (node == dist.length - 1) return 1;
        if (dp[node] != -1) return dp[node];
        long ways = 0;
        for (int[] next : graph[node]) {
            int neighbor = next[0];
            if (dist[node] > dist[neighbor]) {
                ways = (ways + dfs(neighbor)) % MOD;
            }
        }
        return dp[node] = (int) ways;
    }
}