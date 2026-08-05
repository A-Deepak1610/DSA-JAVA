class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int t:tasks)map.put(t,map.getOrDefault(t,0)+1);
        int rounds=0;
        for(Integer key:map.keySet()){
            int freq=map.get(key);
            if(freq==1)return -1;
            while(freq>0){
                if(freq==2) freq-=2;
                else if(freq==3) freq-=3;
                else if(freq-3==1) freq-=2;
                else freq-=3;
                rounds++;
            } 
        }
        return rounds;
    }
}