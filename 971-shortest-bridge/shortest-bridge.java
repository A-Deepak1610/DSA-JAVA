class Solution {
    int[][] dir={{1,0},{-1,0},{0,-1},{0,1}};
    int m,n;
    Queue<int[]> queue;
    public int shortestBridge(int[][] grid) {
       queue=new LinkedList<>();
        m=grid.length;n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        outer:
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    visited[i][j]=true;
                    dfs(grid,i,j,visited);
                    break outer;
                }
            }
        }
        int flips=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                for(int[] d:dir){
                    int nr=d[0]+curr[0];
                    int nc=d[1]+curr[1];
                    if(nr>=0&&nr<m&&nc>=0&&nc<n&&!visited[nr][nc]){
                        if(grid[nr][nc]==1)return flips;
                        queue.add(new int[]{nr,nc});
                        visited[nr][nc]=true;
                    }
                }
            }
            flips++;
        }
        return flips;
    }
    private void dfs(int[][] grid,int i,int j,boolean[][] visited){
        queue.add(new int[]{i,j});
        for(int[] d:dir){
            int nr=d[0]+i;
            int nc=d[1]+j;
            if(nr>=0&&nr<m&&nc>=0&&nc<n&&!visited[nr][nc]&&grid[nr][nc]==1){
                visited[nr][nc]=true;
                dfs(grid,nr,nc,visited);
            }
        }
    }
}