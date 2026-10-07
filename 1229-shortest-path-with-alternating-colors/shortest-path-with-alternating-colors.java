class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] answer=new int[n];
        Arrays.fill(answer,-1);
        answer[0]=0;
        List<Integer>[] blue=new ArrayList[n];
        List<Integer>[] red=new ArrayList[n];
        for(int i=0;i<n;i++){
            blue[i]=new ArrayList<>();
            red[i]=new ArrayList<>();
        }
        for(int[] r:redEdges){
            red[r[0]].add(r[1]);
        }
        for(int[] b:blueEdges){
            blue[b[0]].add(b[1]);
        }
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        queue.add(new int[]{0,1});
        int distance=0;
        boolean[][] visited=new boolean[n][2];
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                int nextColor=1-curr[1];
                if(nextColor==0){
                    for(int nei:blue[curr[0]]){
                        if(!visited[nei][nextColor]){
                            visited[nei][nextColor]=true;
                            answer[nei]=answer[nei]==-1?distance+1:answer[nei];
                            queue.add(new int[]{nei,nextColor});
                        }
                    }
                }
                else{
                    for(int nei:red[curr[0]]){
                        if(!visited[nei][nextColor]){
                            visited[nei][nextColor]=true;
                             answer[nei]=answer[nei]==-1?distance+1:answer[nei];
                            queue.add(new int[]{nei,nextColor});
                        }
                    }
                }
            }
            distance++;
        }
        return answer;
    }
}