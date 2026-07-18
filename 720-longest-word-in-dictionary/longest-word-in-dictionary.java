class Node{
    Node[] link=new Node[26];
    boolean isEnd;
}
class Solution {
    Node root=new Node();
    String ans="";
    public String longestWord(String[] words) {
        for(String s:words){
            insert(s);
        }
        StringBuilder sb=new StringBuilder();
        Node node=root;
        dfs(node,sb);
        return ans;
    }
    private void dfs(Node root,StringBuilder path){
        if(path.length()>ans.length())ans=path.toString();
        for(int i=0;i<26;i++){
            if(root.link[i]!=null&&root.link[i].isEnd){
                path.append((char)('a'+i));
                dfs(root.link[i],path);
                path.deleteCharAt(path.length()-1);
            }
        }
    }
    private void insert(String s){
        Node node=root;
        for(char ch:s.toCharArray()){
            if(node.link[ch-'a']==null)node.link[ch-'a']=new Node();
            node=node.link[ch-'a'];
        }
        node.isEnd=true;
    }
}