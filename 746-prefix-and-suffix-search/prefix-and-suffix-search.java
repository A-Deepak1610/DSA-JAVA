class TrieNode {
    TrieNode[] child = new TrieNode[27];
    int index = -1;
}

class WordFilter {
    TrieNode root = new TrieNode();

    public WordFilter(String[] words) {
        for (int idx = 0; idx < words.length; idx++) {
            String word = words[idx];
            String key = word + "{";
            for (int i = 0; i <= word.length(); i++) {
                TrieNode curr = root;
                // curr.index = idx;
                for (int j = i; j < key.length(); j++) {
                    int c = key.charAt(j) - 'a';
                    if (curr.child[c] == null)
                        curr.child[c] = new TrieNode();
                    curr = curr.child[c];
                    curr.index = idx;
                }
                for (int j = 0; j < key.length(); j++) {
                    int c = key.charAt(j) - 'a';
                    if (curr.child[c] == null)
                        curr.child[c] = new TrieNode();
                    curr = curr.child[c];
                    curr.index = idx;
                }
            }
        }
    }

    public int f(String pref, String suff) {

        TrieNode curr = root;

        String search = suff + "{" + pref;

        for (char ch : search.toCharArray()) {

            int c = ch - 'a';

            if (curr.child[c] == null)
                return -1;

            curr = curr.child[c];
        }

        return curr.index;
    }
}