class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length,count=0;
        Set<Integer>set=new HashSet<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(!set.add(A[i]))count++;
            if(!set.add(B[i]))count++;
            res[i]=count;
        }
        return res;
    }
}