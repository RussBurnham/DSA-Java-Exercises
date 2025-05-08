package dsa2;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        private Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }
    }

    private Node root;

    public Trie() {
        root = new Node(' ');
    }

    public void insert(String word) {
        var current = root;

        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }

        current.isEndOfWord = true;
    }

    //iterative
    // public boolean contains(String word) {
    //     if (word == null)
    //         return false;
    //
    //     var current = root;
    //
    //     for (char ch : word.toCharArray()) {
    //         if (!current.hasChild(ch))
    //             return false;
    //         current = current.getChild(ch);
    //     }
    //
    //     return current.isEndOfWord;
    // }

    // recursive
    public boolean contains(String word) {
        return contains(root, word, 0);
    }

    private boolean contains(Node current, String word, int index) {
        if (index == word.length())
            return current.isEndOfWord;

        char ch = word.charAt(index);
        Node child = current.getChild(ch);
        if (child == null)
            return false;
        
        return contains(child, word, index + 1);
    }

    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    private void preOrderTraverse(Node root) {
        System.out.println(root.value);

        for (var child : root.getChildren()) {
            preOrderTraverse(child);
        }
    }

    public void remove(String word) {
        if (word == null) {
            System.out.println("\nWord does not exist in Trie.");
            return;
        }

        remove(root, word, 0);
    }

    private boolean remove(Node current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord)
                return false;
            current.isEndOfWord = false;
            return !current.hasChildren();
        }

        char ch = word.charAt(index);
        Node child = current.getChild(ch);
        if (child == null)
            return false;

        boolean shouldDeleteNode = remove(child, word, index + 1);

        if (shouldDeleteNode) {
            current.removeChild(ch);
            return !current.hasChildren() && !current.isEndOfWord;
        }

        return false;
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>(); 
        Node lastNode = findLastNode(prefix);
        findWords(lastNode, prefix, words);

        return words;
    }

    private void findWords(Node current, String prefix, List<String> words) {
        if (current == null)
            return;

        if (current.isEndOfWord)
            words.add(prefix);

        for (Node child : current.getChildren()) 
            findWords(child, prefix + child.value, words);
    }

    private Node findLastNode(String prefix) {
        if (prefix == null)
            return null;

        Node lastNode = root;
        for (char c : prefix.toCharArray()) {
            Node child = lastNode.getChild(c);
            if (child == null)
                return null;
            lastNode = child;
        }

        return lastNode;
    }

    public int countWords() {
        return countWords(root);
    }

    private int countWords(Node current) {
        int count = 0;

        if (current.isEndOfWord)
            count += 1;

        for (Node child : current.getChildren()) {
            count += countWords(child);
        }

        return count;
    }

    public String longestCommonPrefix(String[] words) {
        Trie subTrie = new Trie();
        for (String word : words) {
            subTrie.insert(word);
        }
        return longestCommonPrefix(subTrie.root, words, "");
    }

    private String longestCommonPrefix(Node current, String[] words, String prefix) {
        if (current.children.size() != 1 || current.isEndOfWord)
            return prefix;
        
        current = current.getChild(words[0].charAt(prefix.length()));
        prefix += current.value;

        return longestCommonPrefix(current, words, prefix);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        toStringHelper(root, builder, 0);
        return builder.toString();
    }

    private void toStringHelper(Node node, StringBuilder builder, int depth) {
        if (node == null)
            return;

        for (int i = 0; i < depth; i++) {
            builder.append("  ");
        }

        builder.append(node.value == ' ' ? "ROOT" : node.value);
        if (node.isEndOfWord) {
            builder.append(" (end)");
        }
        builder.append("\n");

        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            toStringHelper(entry.getValue(), builder, depth + 1);
        }
    }
}
