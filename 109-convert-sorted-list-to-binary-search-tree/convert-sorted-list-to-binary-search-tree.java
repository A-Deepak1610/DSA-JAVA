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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head,null);
    }
    private TreeNode build(ListNode start,ListNode end){
        if(start==end)return null;
        ListNode mid=mid(start,end);
        TreeNode node=new TreeNode(mid.val);
        node.left=build(start,mid);
        node.right=build(mid.next,end);
        return node;
    }
    private ListNode mid(ListNode start,ListNode end){
        ListNode slow=start,fast=start;
        while(fast!=end&&fast.next!=end){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}