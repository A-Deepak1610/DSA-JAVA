class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumG=0,sumC=0;
        for(int i=0;i<gas.length;i++){
            sumG+=gas[i];
            sumC+=cost[i];
        }
        if(sumC>sumG)return -1;
        int total=0,start=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            if(total<0){
                start=i+1;
                total=0;
            }
        }
        return start;
    }
}