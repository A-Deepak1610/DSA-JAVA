class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int stop : routes[i]) {
                map.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }
        if(!map.containsKey(source) || !map.containsKey(target))
            return -1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedRoutes = new boolean[routes.length];
        Set<Integer> visitedStops = new HashSet<>();
        queue.offer(source);
        visitedStops.add(source);
        int buses = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            buses++;
            while(size-- > 0) {
                int stop = queue.poll();
                for(int route : map.get(stop)) {
                    if(visitedRoutes[route]) continue;
                    visitedRoutes[route] = true;
                    for(int nextStop : routes[route]) {
                        if(nextStop == target)
                            return buses;
                        if(visitedStops.add(nextStop)) {
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}