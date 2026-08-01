class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count=0;
        int prevDeadLine=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(prevDeadLine<=intervals[i][0])prevDeadLine=intervals[i][1];
            else count++;
        }
        return count;
    }
}