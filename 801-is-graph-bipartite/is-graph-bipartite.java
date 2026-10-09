class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        for(int i=0;i<n;i++){
            if(color[i]==0){
                if(!bfs(graph,color,i))return false;
            }
        }
        return true;
    }
    private boolean bfs(int[][] graph,int[] color,int start){
        color[start]=1;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int nei:graph[curr]){
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