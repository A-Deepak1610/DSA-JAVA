class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length,n=image[0].length;
        boolean[][] visited=new boolean[m][n];
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{sr,sc});
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                int currColor=image[curr[0]][curr[1]];
                if(curr[0]+1<m&&image[curr[0]+1][curr[1]]==currColor&&!visited[curr[0]+1][curr[1]]){
                    queue.add(new int[]{curr[0]+1,curr[1]});
                    visited[curr[0]+1][curr[1]]=true;
                }
                if(curr[0]-1>=0&&image[curr[0]-1][curr[1]]==currColor&&!visited[curr[0]-1][curr[1]]){
                    queue.add(new int[]{curr[0]-1,curr[1]});
                    visited[curr[0]-1][curr[1]]=true;
                }
                if(curr[1]+1<n&&image[curr[0]][curr[1]+1]==currColor&&!visited[curr[0]][curr[1]+1]){
                    queue.add(new int[]{curr[0],curr[1]+1});
                    visited[curr[0]][curr[1]+1]=true;
                }
                if(curr[1]-1>=0&&image[curr[0]][curr[1]-1]==currColor&&!visited[curr[0]][curr[1]-1]){
                    queue.add(new int[]{curr[0],curr[1]-1});
                    visited[curr[0]][curr[1]-1]=true;
                }
                image[curr[0]][curr[1]]=color;
            }
        }
        return image;
    }
}