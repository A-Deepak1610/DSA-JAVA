class Solution {
    public int minNumberOperations(int[] target) {
        int count=target[0];
        for(int i=1;i<target.length;i++){
            count+=Math.max(0,target[i]-target[i-1]);
        }
        return count;
    }
}