class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n=nums.length;
        if(n%k!=0)return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:nums)map.put(num,map.getOrDefault(num,0)+1);
        while(!map.isEmpty()){
            int key=map.firstKey();
            int val=map.get(key);
            for(int i=key+1;i<key+k;i++){
                if(!map.containsKey(i))return false;
                int f=map.get(i);
                if(f>1)map.put(i,f-1);
                else map.remove(i);
            }
            if(val>1)map.put(key,val-1);
            else map.remove(key);
        }
        return true;
    }
}