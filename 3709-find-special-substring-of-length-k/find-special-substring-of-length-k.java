class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        Map<Character,Integer>map=new HashMap<>();
        int n=s.length(),l=0;
        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(r>=k){
                char c=s.charAt(l);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)map.remove(c);
                l++;
            }
            if(r>=k-1){
                if(map.size()==1&&map.get(ch)==k){
                    boolean valid=true;
                    if(l>0&&s.charAt(l-1)==ch)valid=false;
                    if(r<n-1&&s.charAt(r+1)==ch)valid=false;
                    if(valid)return true;
                }
            }
        }
        return false;
    }
}