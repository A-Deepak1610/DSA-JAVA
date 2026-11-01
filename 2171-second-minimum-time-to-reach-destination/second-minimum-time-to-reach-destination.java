class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(second, Integer.MAX_VALUE);
        Queue<int[]> queue = new ArrayDeque<>();
        first[1] = 0;
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int t = curr[1];
            if (node == n && t == second[n])
                return t;
            if ((t / change) % 2 == 1) {
                t += change - (t % change);
            }
            int arrival = t + time;
            for (int nei : graph[node]) {
                if (arrival < first[nei]) {
                    second[nei] = first[nei];
                    first[nei] = arrival;
                    queue.offer(new int[]{nei, arrival});
                } else if (arrival > first[nei] &&
                           arrival < second[nei]) {
                    second[nei] = arrival;
                    queue.offer(new int[]{nei, arrival});
                }
            }
        }
        return -1;
    }
}