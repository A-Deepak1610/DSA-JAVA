class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int[] info=new int[2];
                dfs(graph,visited,info,i);
                int nodes=info[0];
                int degreeSum=info[1];
                int edgeSum=degreeSum/2;
                int requiredEdge=nodes*(nodes-1)/2;
                if(requiredEdge==edgeSum)count++;
            }
        }
        return count;
    }
    private void dfs(List<List<Integer>> graph,boolean[] visited,int[] info,int i){
        visited[i]=true;
        info[0]++;
        info[1]+=graph.get(i).size();
        for(int nei:graph.get(i)){
            if(!visited[nei]){
                dfs(graph,visited,info,nei);
            }
        }
    }
}