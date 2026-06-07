// class NodeLL {
//     int data;
//     NodeLL next;

//     NodeLL(int x) {
//         data = x;
//         next = null;
//     }
// }
// class Node {
//     int data;
//     Node left, right;

//     Node(int x) {
//         data = x;
//         left = right = null;
//     }
// }

class Solution {
    public Node linkedListToBinaryTree(NodeLL head) {
        Node root=new Node(head.data);
        NodeLL temp=head.next;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(temp!=null){
            Node curr=queue.poll();
            Node left=new Node(temp.data);
            curr.left=left;
            queue.add(left);
            temp=temp.next;
            if(temp!=null){
                Node right=new Node(temp.data);
                curr.right=right;
                queue.add(right);
                temp=temp.next;
            }
        }
        return root;
    }
}
