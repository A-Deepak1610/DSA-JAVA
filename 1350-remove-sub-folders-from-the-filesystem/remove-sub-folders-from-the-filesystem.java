class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        boolean isFolder;
}
class Solution {
    TrieNode root = new TrieNode();
    public List<String> removeSubfolders(String[] folder) {
        // Build Trie
        for (String path : folder) {
            insert(path);
        }
        List<String> ans = new ArrayList<>();
        // Collect only parent folders
        dfs(root, "", ans);
        return ans;
    }

    private void insert(String path) {
        String[] parts = path.split("/");
        TrieNode node = root;
        for (int i = 1; i < parts.length; i++) {
            // If a parent folder already exists
            // if (node.isFolder) {
            //     return;
            // }
            node.children.putIfAbsent(
                parts[i],
                new TrieNode()
            );
            node = node.children.get(parts[i]);
        }
        node.isFolder = true;
    }


    private void dfs(TrieNode node, String path, List<String> ans) {
        // If this is a folder, add it and stop
        if (node.isFolder) {
            ans.add(path);
            return;
        }
        for (String child : node.children.keySet()) {
            String newPath;
            if (path.equals("")) {
                newPath = "/" + child;
            } 
            else {
                newPath = path + "/" + child;
            }
            dfs(node.children.get(child), newPath, ans);
        }
    }
}