class Solution {
    int[] parent;
    int[] size;
    private int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    private void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB)return;
        if(size[rootA]>size[rootB]){
            parent[rootB]=rootA;
            size[rootA]+=size[rootB];
        }
        else{
            parent[rootA]=rootB;
            size[rootB]+=size[rootA];
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        Map<String,Integer>map=new HashMap<>();//email to account
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                if(!map.containsKey(email))map.put(email,i);
                else{
                    int prevAccount=map.get(email);
                    union(i,prevAccount);
                }
            }
        }
        Map<Integer,List<String>> groups=new HashMap<>();
        for(String email:map.keySet()){
            int account=map.get(email);
            int root=find(account);
            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(email);
        }
        List<List<String>> result=new ArrayList<>();
        for(var entry:groups.entrySet()){
            int root=entry.getKey();
            List<String> emails=entry.getValue();
            Collections.sort(emails);
            List<String> account=new ArrayList<>();
            account.add(accounts.get(root).get(0));
            account.addAll(emails);
            result.add(account);
        }
        return result;
    }
}