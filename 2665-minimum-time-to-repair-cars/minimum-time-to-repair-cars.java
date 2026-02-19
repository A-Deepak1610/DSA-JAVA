class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l=1,r=(Arrays.stream(ranks).min().orElse(0))*(long)cars*cars;
        long time=r;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(canRepair(ranks,mid,cars)){
                time=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return time;
    }
    private boolean canRepair(int[] ranks,long time,int n){
        long totalCar=0;
        for(int r:ranks){
            totalCar+=(long)Math.sqrt(time/r);
        }
        return totalCar>=n;
    }
}