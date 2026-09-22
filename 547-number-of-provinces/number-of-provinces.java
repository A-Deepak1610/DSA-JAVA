class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces=0;
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                provinces++;
                dfs(isConnected,visited,i);
            }
        }
        return provinces;
    }
    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                visited[city] = true;
                dfs(isConnected, visited, neighbor);
            }
        }
    }
}