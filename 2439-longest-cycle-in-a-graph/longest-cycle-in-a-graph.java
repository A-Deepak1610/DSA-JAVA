class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int[] visited=new int[n];
        int[] depth=new int [n];
        int traversalId=1;
        int maxLen=0;
        for(int start=0;start<n;start++){
            if(visited[start]!=0)continue;
            int steps=0;
            int node=edges[start];
            while(node!=-1&&visited[node]==0){
                visited[node]=traversalId;
                depth[node]=steps++;
                node=edges[node];
            }
            if(node!=-1&&visited[node]==traversalId){
                maxLen=Math.max(maxLen,steps-depth[node]);
            }
            traversalId++;
        }
        return maxLen==0?-1:maxLen;
    }
}