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
    public boolean equationsPossible(String[] equations) {
        int n=equations.length;
        DisjointSet djs=new DisjointSet(26);
        for(int i=0;i<n;i++){
           int c1=equations[i].charAt(0);
           int c2=equations[i].charAt(3);
           int eq=equations[i].charAt(1);
           if(eq=='='){
                djs.union(c1-'a',c2-'a');
           }
        }
        for(int i=0;i<n;i++){
           int c1=equations[i].charAt(0);
           int c2=equations[i].charAt(3);
           int eq=equations[i].charAt(1);
            if(eq=='!'){
                if(djs.findParent(c1-'a')==djs.findParent(c2-'a'))return false;
           }
        }
        return true;
    }
}