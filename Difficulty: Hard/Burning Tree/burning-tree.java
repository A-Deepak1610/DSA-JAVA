/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int minTime(Node root, int target) {
        Map<Integer,Node>map=new HashMap<>();
        Set<Integer>visited=new HashSet<>();
        int time=-1;
        Queue<Node>queue=new LinkedList<>();
        Node targetNode=markParent(root,map,target);
        queue.add(targetNode);
        visited.add(target);
        while(!queue.isEmpty()){
            time++;
            int n=queue.size();
            for(int i=0;i<n;i++){
                Node curr=queue.poll();
                if(curr.left!=null&&visited.add(curr.left.data)){
                    queue.add(curr.left);
                }
                if(curr.right!=null&&visited.add(curr.right.data)){
                    queue.add(curr.right);
                }
                if(map.get(curr.data)!=null&&visited.add(map.get(curr.data).data)){
                    queue.add(map.get(curr.data));
                }
            }
            
        }
        return time;
        
    }
    private Node markParent(Node root,Map<Integer,Node> map,int target){
        Queue<Node>queue=new LinkedList<>();
        queue.add(root);
        Node targetNode=null;
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Node parent=queue.poll();
                if(parent.data==target)targetNode=parent;
                if(parent.left!=null){
                    queue.add(parent.left);
                    map.put(parent.left.data,parent);
                }
                if(parent.right!=null){
                    queue.add(parent.right);
                    map.put(parent.right.data,parent);
                }
            }
        }
        return targetNode;
    }
}