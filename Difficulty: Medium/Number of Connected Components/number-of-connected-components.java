class Solution {
    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }
        for(ArrayList<Integer> edge:edges){
            int u=edge.get(0);
            int v=edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited=new boolean[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(adjList,i,visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(List<List<Integer>> adjList,int i,boolean[] visited){
        if(visited[i])return ;
        visited[i]=true;
        for(Integer node:adjList.get(i)){
            dfs(adjList,node,visited);
        }
    }
}