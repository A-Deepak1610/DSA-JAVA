class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int groups=n*2;
        Map<Integer,Integer>map=new HashMap<>();
        for(int[] seat:reservedSeats){
            map.put(seat[0],map.getOrDefault(seat[0],0)|(1<<seat[1]));
        }
        int left=(1<<2)|(1<<3)|(1<<4)|(1<<5);
        int mid=(1<<4)|(1<<5)|(1<<6)|(1<<7);
        int right=(1<<6)|(1<<7)|(1<<8)|(1<<9);
        for(int row:map.values()){
            groups-=2;
            boolean canLeft=(row&left)==0;
            boolean canMid=(row&mid)==0;
            boolean canRight=(row&right)==0;
            if(canLeft&&canRight)groups+=2;
            else if(canLeft||canRight||canMid)groups++;
        }
        return groups;
    }
}