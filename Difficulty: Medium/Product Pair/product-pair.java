class Solution {
    public boolean isProduct(int[] arr, long target) {
        Set<Long>set=new HashSet<>();
        for(long x:arr){
            if(target==0&&x==0)return true;
            if(target%x==0){
                long y=target/x;
                if(set.contains(y))return true;
            }
            set.add(x);
        }
        return false;
    }
};