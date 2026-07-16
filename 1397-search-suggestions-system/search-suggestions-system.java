class Node{
    Node[] link=new Node[26];
    List<String>suggestions=new ArrayList<>();
}
class Solution {
    Node root=new Node();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>>suggestions=new ArrayList<>();
        for(String s:products)insert(s);
        Node curr=root;
        for(char ch:searchWord.toCharArray()){
            if(curr!=null)curr=curr.link[ch-'a'];
            if(curr==null)suggestions.add(new ArrayList<>());
            else suggestions.add(curr.suggestions);
        }
        return suggestions;
    }
    private void insert(String s){
        Node node=root;
        for(char ch:s.toCharArray()){
            int idx=ch-'a';
            if(node.link[idx]==null)node.link[idx]=new Node();
            node=node.link[idx];
            node.suggestions.add(s);
            Collections.sort(node.suggestions);
            if(node.suggestions.size()>3)node.suggestions.remove(3);
        }
    }
}