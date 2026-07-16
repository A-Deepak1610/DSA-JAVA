class Solution {

    class Node {
        Node[] child = new Node[10];
    }

    Node root = new Node();

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        // Insert arr1 numbers into trie
        for (int num : arr1) {
            insert(num);
        }

        int ans = 0;

        // Search arr2 numbers
        for (int num : arr2) {
            ans = Math.max(ans, search(num));
        }

        return ans;
    }

    private void insert(int num) {

        Node node = root;

        String s = String.valueOf(num);

        for (char c : s.toCharArray()) {

            int digit = c - '0';

            if (node.child[digit] == null) {
                node.child[digit] = new Node();
            }

            node = node.child[digit];
        }
    }


    private int search(int num) {

        Node node = root;
        int len = 0;

        String s = String.valueOf(num);

        for (char c : s.toCharArray()) {

            int digit = c - '0';

            if (node.child[digit] == null)
                break;

            len++;
            node = node.child[digit];
        }

        return len;
    }
}