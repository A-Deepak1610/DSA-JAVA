class Solution {
    public int minOperations(String s) {
        int n=s.length();
        char ch='0';
        int count=0;
        for(char c:s.toCharArray()){
            if(c!=ch)count++;
            ch=(ch=='0'?'1':'0');
        }
        // int minCount=count;
        // count=0;
        // ch='1';
        // for(char c:s.toCharArray()){
        //     if(c!=ch)count++;
        //     ch=(ch=='0'?'1':'0');
        // }
        int minCount=Math.min(count,n-count);
        return minCount;
    }
}