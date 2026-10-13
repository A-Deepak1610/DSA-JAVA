class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes=new ArrayList<>();
        int n=graph.length;
        int[] state=new int[n];
        for(int i=0;i<n;i++){
            if(state[i]==0){
                dfs(graph,state,i);
            }
            if(state[i]==2)safeNodes.add(i);
        }
        return safeNodes;
    }
    private boolean dfs(int[][] graph,int[] state,int node){
        state[node]=1;
        for(int nei:graph[node]){
            if(state[nei]==0){
                if(!dfs(graph,state,nei))return false;
            }
            else {
                if(state[nei]==1)return false;
            }
        }
        state[node]=2;
        return true;
    }
}