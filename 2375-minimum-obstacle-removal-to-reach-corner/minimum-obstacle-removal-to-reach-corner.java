class Solution {
    public int minimumObstacles(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        List<int[]>[] graph=new ArrayList[m*n];
        int count=0;
        if(grid[0][0]==1){
            grid[0][0]=0;
            count++;
        }
        for(int i=0;i<m*n;i++)graph[i]=new ArrayList<>();
        int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int node1=i*n+j;
                for(int[] d:dir){
                    int nr=d[0]+i;
                    int nc=d[1]+j;
                    if(nr>=0&&nr<m&&nc>=0&&nc<n){
                        int node2=nr*n+nc;
                        graph[node1].add(new int[]{node2,grid[nr][nc]});
                        graph[node2].add(new int[]{node1,grid[i][j]});
                    }
                }
            }
        }
        int[] distance=new int[n*m];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Queue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{0,0});
        distance[0]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            if(curr[0]==m*n-1)return curr[1]+count;
            for(int[] nei:graph[curr[0]]){
                int currDis=curr[1]+nei[1];
                if(currDis<distance[nei[0]]){
                    distance[nei[0]]=currDis;
                    pq.add(new int[]{nei[0],currDis});
                }               
            }
        }
        return m*n;
    }
}