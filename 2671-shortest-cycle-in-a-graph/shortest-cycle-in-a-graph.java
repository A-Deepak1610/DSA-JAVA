class Solution {
    public int findShortestCycle(int v, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int answer = Integer.MAX_VALUE;
        for (int start = 0; start < v; start++) {
            int[] distance = new int[v];
            int[] parent = new int[v];
            Arrays.fill(distance, -1);
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            distance[start] = 0;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int neighbor : graph.get(current)) {
                    if (distance[neighbor] == -1) {
                        distance[neighbor] = distance[current] + 1;
                        parent[neighbor] = current;
                        queue.offer(neighbor);
                    } else if (parent[current] != neighbor) {
                        answer = Math.min(
                            answer,
                            distance[current] + distance[neighbor] + 1
                        );
                    }
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}