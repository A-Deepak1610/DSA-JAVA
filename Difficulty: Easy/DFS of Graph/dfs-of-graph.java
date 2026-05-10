class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res=new ArrayList<>();
        boolean[] visited=new boolean[adj.size()];
        visited[0]=true;
        dfs(0,adj,visited,res);
        return res;
    }
    private void dfs(int node,ArrayList<ArrayList<Integer>>adj,boolean[] visited,ArrayList<Integer> res){
        visited[node]=true;
        res.add(node);
        for(Integer nei:adj.get(node)){
            if(!visited[nei]){
                dfs(nei,adj,visited,res);
            }
        }
    }
}