class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> capitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> priceHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int i=0;i<capital.length;i++)capitalHeap.add(new int[]{capital[i],profits[i]});
        while (k-- > 0) {
            while(!capitalHeap.isEmpty()&&capitalHeap.peek()[0]<=w)priceHeap.add(capitalHeap.poll()[1]);
            if(priceHeap.isEmpty())break;
            w+=priceHeap.poll();
        }
        return w;
    }
}