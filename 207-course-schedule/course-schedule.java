class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return !isCyclic(numCourses,prerequisites);
    }
    int[] state;
    public boolean isCyclic(int v, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        state = new int[v];
        for (int i = 0; i < v; i++) {
            if (state[i] == 0 && hasCycle(graph, i)) {
                return true;
            }
        }
        return false;
    }
    private boolean hasCycle(List<List<Integer>> graph, int node) {
        state[node] = 1;
        for (int neighbor : graph.get(node)) {
            if (state[neighbor] == 1) {
                return true; // Back edge to the current DFS path
            }
            if (state[neighbor] == 0 && hasCycle(graph, neighbor)) {
                return true;
            }
        }
        state[node] = 2;
        return false;
    }
}