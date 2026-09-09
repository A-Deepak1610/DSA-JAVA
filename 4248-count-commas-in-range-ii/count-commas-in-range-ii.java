class Solution {
    public long countCommas(long n) {
        if(n<=999)return 0;
        long total=0;
        int comma=1;
        long start=1000;
        long end=start*1000-1;
        while(start<=n){
            long count=Math.min(n,end)-start+1;
            total+=count*comma;
            start=start*1000;
            end=start*1000-1;
            comma++;
        } 
        return total;
    }
}