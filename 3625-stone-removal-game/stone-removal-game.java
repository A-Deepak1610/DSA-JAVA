class Solution {
    public boolean canAliceWin(int n) {
        int stone=10;
        while(n>=stone){
            n=n-stone--;
            if(n<stone)return true;
            n=n-stone--;
        }
        return false;
    }
}