/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static Node treeFromString(String s) {
        int[] i={0};
        return preOrder(s,i);
    }
    private static Node preOrder(String s,int[] i){
        if(i[0]>=s.length()||s.charAt(i[0])==')'){
            return null;
        }
        int val=0;
        while(i[0]<s.length()&&s.charAt(i[0])!='('&&s.charAt(i[0])!=')'){
            val=val*10+(s.charAt(i[0])-'0');
            i[0]++;
        }
        Node root=new Node(val);
        if(i[0]<s.length()&&s.charAt(i[0])=='('){
            i[0]++;
            root.left=preOrder(s,i);
            i[0]++;
        }
        if(i[0]<s.length()&&s.charAt(i[0])=='('){
            i[0]++;
            root.right=preOrder(s,i);
            i[0]++;
        }
        return root;
    }
}
