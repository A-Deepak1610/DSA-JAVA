class Solution {
    public long sumXOR(int[] arr) {
        long sum=0;
        long[][] bits=new long[32][2];
        for(int n:arr){
            for(int i=0;i<32;i++){
                int bit=(n)&(1<<i);
                if(bit==0)bits[i][0]++;
                else bits[i][1]++;
            }
        }
        for(int i=0;i<32;i++){
            sum+=(bits[i][0]*bits[i][1])*(long)1<<i;
        }
        return sum;
    }
}