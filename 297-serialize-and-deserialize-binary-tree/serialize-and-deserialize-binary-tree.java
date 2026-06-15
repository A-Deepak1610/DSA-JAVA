/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                if(node==null){
                    sb.append("null ");
                    continue;
                }
                sb.append(node.val+" ");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())return null;
        String[] arr=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        for(int i=1;i<arr.length;i++){
            TreeNode parent=queue.poll();
            if(!arr[i].equals("null")){
                TreeNode left=new TreeNode(Integer.parseInt(arr[i]));
                parent.left=left;
                queue.add(left);
            }
            if(!arr[++i].equals("null")){
                TreeNode right=new TreeNode(Integer.parseInt(arr[i]));
                parent.right=right;
                queue.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));