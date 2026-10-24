class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] day={0,0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int aAM=Integer.parseInt(arriveAlice.substring(0,2));
        int aAD=Integer.parseInt(arriveAlice.substring(3,5));
        int aLM=Integer.parseInt(leaveAlice.substring(0,2));
        int aLD=Integer.parseInt(leaveAlice.substring(3,5));
        int bAM=Integer.parseInt(arriveBob.substring(0,2));
        int bAD=Integer.parseInt(arriveBob.substring(3,5));
        int bLM=Integer.parseInt(leaveBob.substring(0,2));
        int bLD=Integer.parseInt(leaveBob.substring(3,5));
        int aliceDayA=day[aAM]+aAD;
        int aliceDayL=day[aLM]+aLD;

        int bobDayA=day[bAM]+bAD;
        int bobDayL=day[bLM]+bLD;

        return Math.max(0,Math.min(bobDayL,aliceDayL)-Math.max(aliceDayA,bobDayA)+1);
    }
}