class Solution {
    public boolean checkOnesSegment(String s) {
        boolean one=false,zero=false;
        for(char ch:s.toCharArray()){
            if(ch=='0')zero=true;
            else{
                if(zero)return false;
                else one=true;
            } 
        }
        return true;
    }
}