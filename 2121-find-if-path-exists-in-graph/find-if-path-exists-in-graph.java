class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(source);
        while(!queue.isEmpty()){
            int node=queue.poll();
            if(node==destination)return true;
            for(Integer nei:graph.get(node)){
                if(!visited[nei]){
                    queue.add(nei);
                    visited[nei]=true;
                }
            }
        }
        return false;
    }
}