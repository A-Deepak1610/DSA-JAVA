class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        int[] size=new int[n];
        int[] lastSeen=new int[26];
        Arrays.fill(lastSeen,-1);
        List<Integer>[] tree=new ArrayList[n];
        for(int i=0;i<n;i++)tree[i]=new ArrayList<>();
        for(int i=1;i<n;i++){
            tree[parent[i]].add(i);
        }
        lastSeen[s.charAt(0)-'a']=0;
        dfs(tree,0,lastSeen,parent,s);
        for(int i=0;i<n;i++)tree[i]=new ArrayList<>();
        for(int i=1;i<n;i++){
            tree[parent[i]].add(i);
        }
        size(tree,0,size);

        return size;
    }
    private int size(List<Integer>[] tree,int i,int[] size){
        if(tree[i].isEmpty()) return size[i] = 1;
        size[i]=1;
        for(int node:tree[i]){
            size[i]+=size(tree,node,size);
        }
        return size[i];
    }
    private void dfs(List<Integer>[] tree,int i,int[] lastSeen,int[] parent,String s){
        for(int node:tree[i]){
            char ch=s.charAt(node);
            int lastIdx=lastSeen[ch-'a'];
            if(lastSeen[ch-'a']!=-1){
                parent[node]=lastSeen[ch-'a'];
            }
            lastSeen[ch-'a']=node;
            dfs(tree,node,lastSeen,parent,s);
            lastSeen[ch-'a']=lastIdx;
        }
    }
}