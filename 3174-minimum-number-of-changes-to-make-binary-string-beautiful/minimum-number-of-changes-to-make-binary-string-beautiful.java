class Solution {
    public int minChanges(String s) {
        char curr=s.charAt(0);
        int currLen=0,change=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==curr)currLen++;
            else{
                if(currLen%2==0){
                    curr=s.charAt(i);
                    currLen=1;
                }
                else{
                    curr=s.charAt(i);
                    change++;
                    currLen=0;
                }
            }
        }
        return change;
    }
}