class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] group=new int[n+1];
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++)graph.add(new ArrayList<>());
        for(int[] edge:dislikes){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for(int i=1;i<=n;i++){
            if(group[i]==0)
                if(!bfs(graph,i,group))return false;
        }
        return true;
    }
    private boolean bfs(List<List<Integer>> graph,int start,int[] color){
        color[start]=1;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int nei:graph.get(curr)){
                if(color[nei]==0){
                    queue.add(nei);
                    color[nei]=color[curr]==1?2:1;
                }
                else{
                    if(color[nei]==color[curr])return false;
                }
            }
        }
        return true;
    }
}