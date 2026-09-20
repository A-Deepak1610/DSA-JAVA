class Solution {
    Map<Integer,Integer>map;
    int[][] dp;
    public int lenLongestFibSubseq(int[] arr) {
        map=new HashMap<>();
        int n=arr.length;
        dp=new int[n][n];
        for(int[] d:dp)Arrays.fill(d,-1);
        for(int i=0;i<n;i++)map.put(arr[i],i);
        int maxLen=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int len=solve(arr,i,j);
                maxLen=Math.max(maxLen,len==0?0:2+len);
            }
        }
        return maxLen;
    }
    private int solve(int[] arr,int i,int j){
        int nxt=arr[i]+arr[j];
        int maxLen=0;
        if(map.containsKey(nxt)){
            maxLen=Math.max(maxLen,1+solve(arr,j,map.get(nxt)));
        }
        return maxLen;
    }
}