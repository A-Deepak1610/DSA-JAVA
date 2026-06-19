class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCost=0,oddCost=0;
        for(int pos:position){//even
            if(pos%2!=0)evenCost++;
        }
        for(int pos:position){//odd
            if(pos%2==0)oddCost++;
        }
        return Math.min(evenCost,oddCost);
    }
}