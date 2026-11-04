class DisjointSet{
    int[] parent,rank;
    DisjointSet(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<=n;i++)parent[i]=i;
    }
    int findParent(int i){
        if(parent[i]==i)return i;
        return parent[i]=findParent(parent[i]);
    }
    void union(int i,int j){
        int pi=findParent(i),pj=findParent(j);
        if(pi==pj)return;
        if(rank[pi]<rank[pj]){
            parent[pi]=pj;
        }
        else if(rank[pj]<rank[pi]){
            parent[pj]=pi;
        }
        else{
            parent[pj]=pi;
            rank[pi]++;
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DisjointSet djs=new DisjointSet(n);
        for(int i=0;i<n;i++){
            if(djs.findParent(edges[i][0])==djs.findParent(edges[i][1]))return edges[i];
            else djs.union(edges[i][0],edges[i][1]);
        }
        return new int[0];
    }
}