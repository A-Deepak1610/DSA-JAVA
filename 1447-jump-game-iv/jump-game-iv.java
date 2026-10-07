class Solution {
    public int minJumps(int[] arr) {
        List<List<Integer>> graph=new ArrayList<>();
        int n=arr.length;
        Map<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        int distance=0;
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        visited[0]=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int currIdx=queue.poll();
                if(currIdx==n-1)return distance;
                List<Integer> neighbors = map.get(arr[currIdx]);
                if (currIdx - 1 >= 0) {
                    neighbors.add(currIdx - 1);
                }
                if (currIdx + 1 < n) {
                    neighbors.add(currIdx + 1);
                }
                for (int nei : neighbors) {
                    if (!visited[nei]) {
                        visited[nei] = true;
                        queue.add(nei);
                    }
                }
                neighbors.clear();
            }
            distance++;
        }
        return -1;
    }
}