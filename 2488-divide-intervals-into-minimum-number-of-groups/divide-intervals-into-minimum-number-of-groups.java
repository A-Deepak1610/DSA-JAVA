class Solution {
    public int minGroups(int[][] intervals) {
        int n=intervals.length,k=0;
        int[][] pair=new int[2*n][2];
        for(int i=0;i<n;i++){
            pair[k][0]=intervals[i][0];
            pair[k++][1]=1;
            pair[k][0]=intervals[i][1];
            pair[k++][1]=-1;
        }
        Arrays.sort(pair,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            return b[1]-a[1];
            });
        int overlap=0,maxOverlap=0;
        for(int[] p:pair){
            overlap+=p[1];
            // System.out.println(p[1]);
            maxOverlap=Math.max(maxOverlap,overlap);
        }
        return maxOverlap;
    }
}