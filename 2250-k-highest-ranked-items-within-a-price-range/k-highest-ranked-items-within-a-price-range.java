class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        int x=start[0],y=start[1],low=pricing[0],high=pricing[1],m=grid.length,n=grid[0].length;
        // dis price row col
        Set<String>seen=new HashSet<>();
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            if(a[1]!=b[1])return a[1]-b[1];
            if(a[2]!=b[2])return a[2]-b[2];
            return a[3]-b[3];
        });
        pq.add(new int[]{0,grid[x][y],x,y});
        seen.add(x+" "+y);
        while(!pq.isEmpty()&&ans.size()<k){
            int[] arr=pq.poll();
            int r=arr[2],c=arr[3];
            if(arr[1]>=low&&arr[1]<=high)ans.add(Arrays.asList(r,c));
            if(r-1>=0&&grid[r-1][c]!=0&&seen.add(r-1+" "+c))pq.add(new int[]{arr[0]+1,grid[r-1][c],r-1,c});
            if(r+1<m&&grid[r+1][c]!=0&&seen.add(r+1+" "+c))pq.add(new int[]{arr[0]+1,grid[r+1][c],r+1,c});
            if(c-1>=0&&grid[r][c-1]!=0&&seen.add(r+" "+(c-1)))pq.add(new int[]{arr[0]+1,grid[r][c-1],r,c-1});
            if(c+1<n&&grid[r][c+1]!=0&&seen.add(r+" "+(c+1)))pq.add(new int[]{arr[0]+1,grid[r][c+1],r,c+1});
        }
        return ans;
    }
}