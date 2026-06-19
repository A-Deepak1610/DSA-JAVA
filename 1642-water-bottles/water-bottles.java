class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink=numBottles,empty=numBottles;
        while (empty>=numExchange){
            drink+=empty/numExchange;
            int temp=empty/numExchange;
            empty=empty%numExchange;
            empty+=temp;
        }
        return drink;
    }
}