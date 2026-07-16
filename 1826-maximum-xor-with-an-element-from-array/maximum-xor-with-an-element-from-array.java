import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    // Insert a number into the Trie
    private void insert(int num) {
        TrieNode curr = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (curr.child[bit] == null) {
                curr.child[bit] = new TrieNode();
            }

            curr = curr.child[bit];
        }
    }

    // Find maximum XOR with x
    private int getMaxXor(int x) {
        TrieNode curr = root;
        int ans = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = (x >> i) & 1;

            // Prefer opposite bit
            if (curr.child[1 - bit] != null) {
                ans |= (1 << i);
                curr = curr.child[1 - bit];
            } else {
                curr = curr.child[bit];
            }
        }

        return ans;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {

        Arrays.sort(nums);

        int q = queries.length;

        // {m, x, originalIndex}
        int[][] offline = new int[q][3];

        for (int i = 0; i < q; i++) {
            offline[i][0] = queries[i][1]; // m
            offline[i][1] = queries[i][0]; // x
            offline[i][2] = i;             // original index
        }

        Arrays.sort(offline, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[q];

        int ptr = 0;

        for (int[] query : offline) {

            int m = query[0];
            int x = query[1];
            int index = query[2];

            // Insert all numbers <= m
            while (ptr < nums.length && nums[ptr] <= m) {
                insert(nums[ptr]);
                ptr++;
            }

            if (ptr == 0) {
                ans[index] = -1;
            } else {
                ans[index] = getMaxXor(x);
            }
        }

        return ans;
    }
}