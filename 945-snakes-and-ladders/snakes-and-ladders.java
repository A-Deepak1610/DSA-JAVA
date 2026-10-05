class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int target=n*n;
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[n*n+1];
        queue.offer(1);
        visited[1]=true;
        int steps=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int curr=queue.poll();
                if(curr==target)return steps;
                for(int next=curr+1;next<=Math.min(curr+6,n*n);next++){
                    int rowFromBottom=(next-1)/n;
                    int row=n-1-rowFromBottom;
                    int col=(next-1)%n;
                    if(rowFromBottom%2==1)col=n-1-col;
                    int dest=board[row][col]==-1?next:board[row][col];
                    if(!visited[dest]){
                        queue.add(dest);
                        visited[dest]=true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}