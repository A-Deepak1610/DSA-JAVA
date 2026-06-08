/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node compute(Node head) {
        Stack<Node>stack=new Stack<>();
        Node curr=head;
        while(curr!=null){
            while(!stack.isEmpty()&&stack.peek().data<curr.data){
                stack.pop();
            }
            stack.push(curr);
            curr=curr.next;
        }
        Node newHead=stack.get(0);
        curr=newHead;
        for(int i=1;i<stack.size();i++){
            curr.next=stack.get(i);
            curr=curr.next;
        }
        curr.next=null;
        return newHead;
    }
}