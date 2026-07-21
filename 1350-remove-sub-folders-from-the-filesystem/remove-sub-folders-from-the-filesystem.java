class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String>res=new ArrayList<>();
        Arrays.sort(folder);
        for(String s:folder){
            if(res.isEmpty()||!s.startsWith(res.get(res.size()-1)+"/")){
                res.add(s);
            }
        }
        return res;
    }
}