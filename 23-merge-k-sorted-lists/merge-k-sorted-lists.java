/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode ln:lists)if(ln!=null)pq.add(ln);
        ListNode head=new ListNode(-1);
        ListNode temp=head;
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            temp.next=node;
            temp=node;
            if(node.next!=null)pq.add(node.next);
        }
        return head.next;
    }
}