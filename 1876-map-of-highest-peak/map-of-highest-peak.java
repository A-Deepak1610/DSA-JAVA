class Solution {
    public int[][] highestPeak(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int[][] dis=new int[m][n];
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1)queue.add(new int[]{i,j});
                else dis[i][j]=-1;
            }
        }
        int[][] dir={{1,0},{-1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            for(int[] d:dir){
                int nr=curr[0]+d[0];
                int nc=curr[1]+d[1];
                if(nr>=0&&nr<m&&nc>=0&&nc<n&&dis[nr][nc]==-1){
                    dis[nr][nc]=dis[curr[0]][curr[1]]+1;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        return dis;
    }
}