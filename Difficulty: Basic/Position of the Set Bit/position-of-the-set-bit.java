class Solution {
    public int findPosition(int n) {
        if((n&(n-1))==0){
            for(int i=0;i<32;i++){
                    if ((n & 1) == 1) return i + 1;
                n=n>>1;
            }
        }
        return -1;
    }
}