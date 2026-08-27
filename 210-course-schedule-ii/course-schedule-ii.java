class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return topoSort(numCourses,prerequisites);
    }
    public int[] topoSort(int V, int[][] edges) {
        int[] res=new int[V];
        int idx=0;
        List<List<Integer>>adj=new ArrayList<>();
        int[] indegrees=new int[V];
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            adj.get(v).add(u);
            indegrees[u]++;
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegrees[i]==0)queue.add(i);
        }
        int count=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            res[idx++]=node;
            count++;
            for(int neighbor:adj.get(node)){
                indegrees[neighbor]--;
                if(indegrees[neighbor]==0)queue.add(neighbor);
            }
        }
        return count!=V?new int[0]:res;
    }
}