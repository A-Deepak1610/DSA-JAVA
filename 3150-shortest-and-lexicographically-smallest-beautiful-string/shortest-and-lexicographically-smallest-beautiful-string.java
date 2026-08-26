class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans="";
        int ones=0;
        int left=0;
        for(int r=0;r<s.length();r++){
            if(s.charAt(r)=='1')ones++;
            while(ones>k){
                if(s.charAt(left)=='1')ones--;
                left++;
            }
            if(ones==k){
                while(left<r&&s.charAt(left)=='0')left++;
                String cur=s.substring(left,r+1);
                if (ans.isEmpty()||cur.length()<ans.length()||(cur.length()==ans.length()&&cur.compareTo(ans)<0)){
                    ans = cur;
                }
            }
        }
        return ans;
    }
}