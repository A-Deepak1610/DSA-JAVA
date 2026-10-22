class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue=new LinkedList<>();
        int sr,sc;
        int m=grid.length,n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        outer:
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    queue.add(new int[]{i,j});
                    visited[i][j]=true;
                    break outer;
                }
            }
        }
        int perimeter=0;
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            for(int[] d:dir){
                int newRow=d[0]+curr[0];
                int newCol=d[1]+curr[1];
                 if (newRow < 0 || newRow >= m ||
                    newCol < 0 || newCol >= n) {
                    perimeter++;
                }
                else if (grid[newRow][newCol] == 0) {
                    perimeter++;
                }
                else if (!visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }

        }
        return perimeter;
    }
}