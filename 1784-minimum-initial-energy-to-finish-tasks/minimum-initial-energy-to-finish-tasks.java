class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->(b[1]-b[0])-(a[1]-a[0]));
        int totalEnergy=0,energy=0;
        for(int[] t:tasks){
            
            if(energy<t[1]){
                totalEnergy+=(t[1]-energy);
                energy=t[1];
            }
            energy-=t[0];
        }
        return totalEnergy;
    }
}