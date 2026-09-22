class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        Queue<Integer>queue=new LinkedList<>();
        queue.add(0);
        int room=1;
        visited[0]=true;
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int key:rooms.get(node)){
                if(!visited[key]){
                    room++;
                    queue.add(key);
                    visited[key]=true;
                }
            }
            if(room==n)return true;
        }
        return false;
    }
}