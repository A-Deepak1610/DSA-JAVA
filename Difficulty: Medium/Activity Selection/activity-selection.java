class Pair{
    int start,finish;
    Pair(int start,int finish){
        this.start=start;
        this.finish=finish;
    }
}
class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n=start.length;
        Pair[] pair=new Pair[n];
        for(int i=0;i<n;i++)pair[i]=new Pair(start[i],finish[i]);
        Arrays.sort(pair,(a,b)->a.finish-b.finish);
        int act=0;
        int prevFinish=pair[0].finish;
        for(int i=1;i<n;i++){
            if(pair[i].start>prevFinish){
                act++;
                prevFinish=pair[i].finish;
            }
        }
        return act+1;
    }
}
