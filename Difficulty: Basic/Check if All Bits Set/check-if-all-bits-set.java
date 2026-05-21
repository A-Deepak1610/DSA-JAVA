class Solution {
    public boolean isBitSet(int n) {
        if(n==0)return false;
        for(int i=0;i<32;i++){
            if(n==0)break;
            if((n&(1))==0)return false;
            n=n>>1;
        }
        return true;
    }
};