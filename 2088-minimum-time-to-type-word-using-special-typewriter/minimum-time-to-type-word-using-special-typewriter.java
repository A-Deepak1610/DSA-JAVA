class Solution {
    public int minTimeToType(String word) {
        int sec=0;
        char curr='a';
        for(char ch:word.toCharArray()){
            int move=Math.min(Math.abs(ch-curr),26-Math.abs(ch-curr));
            sec+=move;
            sec++;
            curr=ch;
        }
        return sec;
    }
}