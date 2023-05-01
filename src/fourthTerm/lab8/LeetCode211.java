package fourthTerm.lab8;

public class LeetCode211 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println("return False: " + wordDictionary.search("pad"));
        System.out.println("return True: " + wordDictionary.search("bad"));
        System.out.println("return True: " + wordDictionary.search(".ad"));
        System.out.println("return True: " + wordDictionary.search("b.."));
    }
}

class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.getOrCreateChild(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode node, String word, int index) {
        if (index == word.length()) return node.isWord;
        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && searchHelper(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        }

        TrieNode child = node.getChild(c);
        return child != null && searchHelper(child, word, index + 1);
    }

    private static class TrieNode {
        private boolean isWord;
        private final TrieNode[] children = new TrieNode[26];

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        public TrieNode getOrCreateChild(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
            }
            return children[c - 'a'];
        }
    }
}
