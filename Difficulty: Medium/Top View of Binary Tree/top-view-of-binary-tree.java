/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Pair{
    Node node;
    int hd;
    Pair(Node node,int hd){
        this.node=node;
        this.hd=hd;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        TreeMap<Integer,Integer>map=new TreeMap<>();
        ArrayList<Integer>topView=new ArrayList<>();
        Queue<Pair>queue=new LinkedList<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Pair p=queue.poll();
                if(p.node.left!=null)queue.add(new Pair(p.node.left,p.hd-1));
                if(p.node.right!=null)queue.add(new Pair(p.node.right,p.hd+1));
                map.putIfAbsent(p.hd,p.node.data);
            }
        }
        for(Integer val:map.values())topView.add(val);
        return topView;
    }
}