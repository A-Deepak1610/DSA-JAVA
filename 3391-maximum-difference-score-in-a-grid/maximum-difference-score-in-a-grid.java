class Solution {
    int m,n;
    public int maxScore(List<List<Integer>> grid) {
        m=grid.size();
        n=grid.get(0).size();
        int[] minCol=new int[n];
        Arrays.fill(minCol,Integer.MAX_VALUE);
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            int minLeft=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                int curr=grid.get(i).get(j);
                int minPrev=Math.min(minLeft,minCol[j]);
                if(minPrev!=Integer.MAX_VALUE)ans=Math.max(ans,curr-minPrev);
                minCol[j]=Math.min(minCol[j],curr);
                minLeft=Math.min(minLeft,minCol[j]);
            }
        }
        return ans;
    }
}