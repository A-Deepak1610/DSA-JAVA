class Solution {
    public boolean checkString(String s) {
        boolean b=false;
        for(char ch:s.toCharArray()){
            if(ch=='a'){
                if(b)return false;
            }
            else if(ch=='b'){
                b=true;
            }
        }
        return true;
    }
}