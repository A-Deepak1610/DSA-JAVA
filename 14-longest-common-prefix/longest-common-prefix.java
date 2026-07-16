class Node{
    Node[] link=new Node[26];
    int count;
}
class Solution {
    Node root=new Node();
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        for(String s:strs){
            insert(s);
        }
        return strs[0].substring(0,getLongesPrefixLen(strs[0],n));
    }
    private void insert(String s){
        Node node=root;
        for(char ch:s.toCharArray()){
            if(node.link[ch-'a']==null)node.link[ch-'a']=new Node();
            node.link[ch-'a'].count++;
            node=node.link[ch-'a'];
        }
    }
    private int getLongesPrefixLen(String s,int n){
        Node node=root;
        int len=0;
        for(char ch:s.toCharArray()){
            if(node.link[ch-'a'].count!=n)return len;
            len++;
            node=node.link[ch-'a'];
        }
        return len;
    }
}