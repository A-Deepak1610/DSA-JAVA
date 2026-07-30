class Pair{
    int val , wt;
    double rt;
    Pair(int val,int wt){
        this.val=val;
        this.wt=wt;
        rt=(1.0*val/wt);
    }
}
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n=val.length;
        Pair[] pair=new Pair[n];
        for(int i=0;i<n;i++)pair[i]=new Pair(val[i],wt[i]);
        Arrays.sort(pair,(a,b)->Double.compare(b.rt,a.rt));
        double value=0.0;
        for(int i=0;i<n;i++){
            if(pair[i].wt<=capacity){
                value+=pair[i].val;
                capacity-=pair[i].wt;
            }
            else{
                value+=pair[i].rt*capacity;
                return value;
            }
        }
        return value;
    }
}