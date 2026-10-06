class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];
            graph[u].add(new int[]{v, dist});
            graph[v].add(new int[]{u, dist});
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int minScore = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int[] edge : graph[city]) {
                int nextCity = edge[0];
                int distance = edge[1];
                minScore = Math.min(minScore, distance);
                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }
        return minScore;
    }
}