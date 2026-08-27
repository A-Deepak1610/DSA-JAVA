class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> res=new ArrayList<>();
        List<List<Integer>>adj=new ArrayList<>();
        int[] indegrees=new int[V];
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            adj.get(u).add(v);
            indegrees[v]++;
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegrees[i]==0)queue.add(i);
        }
        while(!queue.isEmpty()){
            int node=queue.poll();
            res.add(node);
            for(int neighbor:adj.get(node)){
                indegrees[neighbor]--;
                if(indegrees[neighbor]==0)queue.add(neighbor);
            }
        }
        return res;
    }
}