class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        List<int[]>[] graph=new ArrayList[n+1];
        for(int i=0;i<=n;i++)graph[i]=new ArrayList<>();
        for(int[] time:times){
            int u=time[0],v=time[1],w=time[2];
            graph[u].add(new int[]{v,w});
        }
        Queue<int[]> pq=new LinkedList<>();
        pq.add(new int[]{k,0});
        distance[k]=0;
        distance[0]=0;
        int maxTime=Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            for(int[] nei:graph[curr[0]]){
                int currDis=curr[1]+nei[1];
                if(currDis<distance[nei[0]]){
                    distance[nei[0]]=currDis;
                    pq.add(new int[]{nei[0],currDis});
                }               
            }
        }
        for(int d:distance){
            if(d==Integer.MAX_VALUE)return -1;
            maxTime=Math.max(maxTime,d);
        }
        return maxTime;
    }
}