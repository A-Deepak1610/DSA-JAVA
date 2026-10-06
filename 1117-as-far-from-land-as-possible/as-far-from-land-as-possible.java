class Solution {
    public int maxDistance(int[][] grid) {
        boolean hasWater=false,hasLand=false;
        Queue<int[]> queue=new LinkedList<>();
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    queue.add(new int[]{i,j});
                    hasLand=true;
                }
                if(grid[i][j]==0)hasWater=true;
            }
        }
        if(!hasLand || !hasWater)return -1;
        int distance=-1;
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            distance++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                for(int[] d:dir){
                    int nrow=curr[0]+d[0],ncol=curr[1]+d[1];
                    if(nrow>=0&&nrow<n&&ncol>=0&&ncol<n&&grid[nrow][ncol]==0){
                        grid[nrow][ncol]=1;
                        queue.add(new int[]{nrow,ncol});
                    }
                }
            }
        }
        return distance;
    }
}