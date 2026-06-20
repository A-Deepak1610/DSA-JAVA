class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        int[][] dir={
            {-1,0},{1,0},{0,-1},{0,1}
        };
        int ones=0;
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)queue.add(new int[]{i,j});
                else if(grid[i][j]==1)ones++;
            }
        }
        if(ones==0)return 0;
        int time=0;
        while(!queue.isEmpty()&&ones>0){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                for(int[] d:dir){
                    int nr=curr[0]+d[0];
                    int nc=curr[1]+d[1];
                    if(nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]==1){
                        ones--;
                        grid[nr][nc]=2;
                        queue.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }
        return ones!=0?-1:time;
    }
}