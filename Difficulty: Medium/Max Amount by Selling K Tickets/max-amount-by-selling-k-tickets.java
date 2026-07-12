class Solution {
    public int maxAmount(int[] arr, int k) {
        // code here
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        for(int n:arr)pq.add(n);
        int maxAmt=0,mod=1000_000_007;
        while(k-->0&&!pq.isEmpty()){
            int n=pq.poll();
            maxAmt=(maxAmt+n)%mod;
            if(n>1)pq.add(n-1);
        }
        return maxAmt;
    }
}