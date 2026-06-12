class Solution {
    public boolean kSubstr(String s, int k) {
        int n=s.length();
        if(n%k!=0)return false;
        Map<String,Integer>map=new HashMap<>();
        for(int i=0;i<n;i+=k)map.put(s.substring(i,i+k),map.getOrDefault(s.substring(i,i+k),0)+1);
        if(map.size()==1)return true;
        if(map.size()!=2)return false;
        for(int val:map.values()){
            if(val==1||val==(n/k)-1)return true;
        }
        return false;
    }
}