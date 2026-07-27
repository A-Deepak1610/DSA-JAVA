/* Structure of Binary Tree Node
class Node {
	int data;
	Node left, right;
	
	Node(int val) {
		data = val;
		left = right = null;
	}
} */

class Solution {
	HashMap<Integer, Integer>mirrorIndex = new HashMap<>();
	public Node constructBinaryTree(int[] pre, int[] preMirror) {
		int n = pre.length;
		for (int i = 0; i < n; i++) {
			mirrorIndex.put(preMirror[i], i);
		}
		return construct(pre, preMirror, 0, n - 1, 0, n - 1);
	}
	private Node construct(int[] pre, int[] preMirror, int preStart, int preEnd, int mirrorStart, int mirrorEnd) {
		if (preStart>preEnd)return null;
		Node node = new Node(pre[preStart]);
// 		if(preStart==preEnd)return node;
		int idx = mirrorIndex.get(pre[preStart + 1]);
		int rightSize = idx - mirrorStart - 1;
		int total=preEnd-preStart+1;
		int leftSize=total-rightSize-1;
		node.left = construct(pre, preMirror, preStart + 1,preStart+leftSize,mirrorStart+rightSize+1,mirrorEnd);
		node.right = construct(pre, preMirror,preStart+leftSize+1,preEnd,mirrorStart+1,mirrorStart+rightSize);
		return node;
	}
}
