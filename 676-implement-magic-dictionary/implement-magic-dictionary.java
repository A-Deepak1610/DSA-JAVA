class Node{
    Node[] link=new Node[26];
    boolean isEnd=false;
}
class MagicDictionary {
    Node root;
    public MagicDictionary() {
        root=new Node();
    }
    public void buildDict(String[] dictionary) {
        for(String s:dictionary)insert(s);
    }  
    public boolean search(String searchWord) {
       return dfs(root,searchWord,0,false);
    }
    private boolean dfs(Node node,String s,int st,boolean changed){
        if(node==null)return false;
        if(st==s.length()){
            return changed&&node.isEnd;
        }
        int curr=s.charAt(st)-'a';
        if(node.link[curr]!=null){
             if(dfs(node.link[curr],s,st+1,changed))return true;;
        }
        if(!changed){
            for(int i=0;i<26;i++){
                if(i==curr)continue; 
                if(node.link[i]!=null){
                    if(dfs(node.link[i],s,st+1,true)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private void insert(String s){
        Node node=root;
        for(char ch:s.toCharArray()){
            int idx=ch-'a';
            if(node.link[idx]==null)node.link[idx]=new Node();
            node=node.link[idx];
        }
        node.isEnd=true;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */