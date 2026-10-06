class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++)graph.add(new ArrayList<>());
        graph.get(0).add(1);
        graph.get(x).add(y);
        graph.get(y).add(x);
        int[] ans=new int[n];
        for(int i=1;i<n;i++){
            graph.get(i).add(i+1);
            graph.get(i+1).add(i);
        }
        for (int start = 1; start <= n; start++) {
            int[] dist = new int[n + 1];
            Arrays.fill(dist, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            dist[start] = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int nei : graph.get(node)) {
                    if (dist[nei] == -1) {
                        dist[nei] = dist[node] + 1;
                        queue.offer(nei);
                    }
                }
            }
            for (int end = 1; end <= n; end++) {
                if (start != end) {
                    int d = dist[end];
                    ans[d - 1]++;
                }
            }
        }
        return ans;
    }
}