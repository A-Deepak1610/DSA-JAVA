class Graph {
    int[][] dist;
    int n;
    public Graph(int n, int[][] edges) {
        this.n=n;
        dist=new int[n][n];
        for(int[] d:dist)Arrays.fill(d,(int)1e9);
        for(int i=0;i<n;i++)dist[i][i]=0;
        for(int[] edge:edges){
            dist[edge[0]][edge[1]]=edge[2];
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        dist[edge[0]][edge[1]]=Math.min(dist[edge[0]][edge[1]],edge[2]);
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return dist[node1][node2]==1e9?-1:dist[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */