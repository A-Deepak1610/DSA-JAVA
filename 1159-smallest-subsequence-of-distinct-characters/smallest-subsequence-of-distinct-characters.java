class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIdx=new int[26];
        boolean[] seen=new boolean[26];
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<s.length();i++)lastIdx[s.charAt(i)-'a']=i;
        for(int i=0;i<s.length();i++){
            int curr=s.charAt(i)-'a';
            if(seen[curr])continue;
            while(!stack.isEmpty()&&stack.peek()>curr&&lastIdx[stack.peek()]>i){
                seen[stack.pop()]=false;
            }
            seen[curr]=true;
            stack.push(curr);
        }
        StringBuilder sb=new StringBuilder();
        for(Integer i:stack){
            sb.append((char)(i+'a'));
        }
        return sb.toString();
    }
}