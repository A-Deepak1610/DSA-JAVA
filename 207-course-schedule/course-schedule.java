class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return !isCyclic(numCourses,prerequisites);
    }
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
        }
        boolean[] visited=new boolean[V];
        boolean[] path=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,path))return true;
            }
        }
        return false;
    }
    private boolean dfs(int node,List<List<Integer>> adj,boolean[] visited,boolean[] path){
        visited[node]=true;
        path[node]=true;
        for(int neighbor:adj.get(node)){
            if(path[neighbor])return true;
            if(!visited[neighbor]){
                if(dfs(neighbor,adj,visited,path))return true;
            }
        }
        path[node]=false;
        return false;
    }
}