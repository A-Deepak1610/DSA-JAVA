class Node{
    Node[] child=new Node[26];
    boolean isEnd=false;
    int sum=0;
}
class MapSum {
    Node root;
    Map<String,Integer>map;
    public MapSum() {
        root=new Node();
        map=new HashMap<>();
    }
    public void insert(String key, int val) {
        Node node = root;
        if(map.containsKey(key)){
            for(char ch:key.toCharArray()){
                node.child[ch-'a'].sum+=val;
                node.child[ch-'a'].sum-=map.get(key);
                node=node.child[ch-'a'];
            }
        }
        else {
            for(char ch:key.toCharArray()){
                if(node.child[ch-'a']==null)node.child[ch-'a']=new Node();
                node.child[ch-'a'].sum+=val;
                node=node.child[ch-'a'];
            }
        }
        map.put(key,val);
        node.isEnd=true;
    }
    
    public int sum(String prefix) {
        Node node=root;
        for(char ch:prefix.toCharArray()){
            if(node.child[ch-'a']==null)return 0;
            node=node.child[ch-'a'];
        }
        return node.sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */