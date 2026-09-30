class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int n=s.length();
        int[] res=new int[n];
        int depth=0,i=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                depth++;
                res[i++]=depth%2;
            }
            else{
                res[i++]=depth%2;
                depth--;
            }
        }
        return res;
    }
}