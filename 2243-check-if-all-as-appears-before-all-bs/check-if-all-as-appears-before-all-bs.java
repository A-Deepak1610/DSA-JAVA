class Solution {
    public boolean checkString(String s) {
        boolean a=false,b=false;
        for(char ch:s.toCharArray()){
            if(ch=='a'){
                if(b)return false;
                a=true;
            }
            else if(ch=='b'){
                
                b=true;
            }
        }
        return true;
    }
}