class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(new int[] { road[1], road[2] });
            graph[road[1]].add(new int[] { road[0], road[2] });
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[] { 0, 0 });
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long time = curr[1];
            if (time > dist[node])
                continue;
            for (int[] nei : graph[node]) {
                int next = nei[0];
                long newTime = time + nei[1];
                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    ways[next] = ways[node];
                    pq.offer(new long[] { next, newTime });
                } else if (newTime == dist[next]) {
                    ways[next] = (int) ((ways[next] + (long) ways[node]) % MOD);
                }
            }
        }
        return ways[n - 1];
    }
}