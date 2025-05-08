package dsa2;

public class PreOrderPracticeTree {
    private class Node {
        private char letter;
        private Node leftChild;
        private Node rightChild;

        private Node(char letter) {
            this.letter = letter;
        }
    }

    private Node root;

    public void insert(char letter) {
        root = insert(root, letter);
    }

    private Node insert(Node current, char letter) {
        if (current == null)
            return new Node(letter);

        if (current.leftChild != null && current.rightChild == null)
            current.rightChild = insert(current.rightChild, letter);
        else
            current.leftChild = insert(current.leftChild, letter);

        return current;
    }

    public String preOrderString() {
        return preOrderString(root);
    }

    private String preOrderString(Node current) {
        if (current == null)
            return "";  

        return current.letter + preOrderString(current.leftChild) + preOrderString(current.rightChild);
    }

    public String preOrderLeaves() {
        return preOrderLeaves(root);
    }

    private String preOrderLeaves(Node current) {
        if (current == null)
            return "";
        else if (isLeaf(current))
            return "" + current.letter;

        
        return preOrderLeaves(current.leftChild) + preOrderLeaves(current.rightChild);
    }

    public boolean isLeaf(Node node) {
        return node.leftChild == null;
    }

    public int capitalLetterCount() {
        return capitalLetterCount(root);
    }

    private int capitalLetterCount(Node current) {
        if (current == null)
            return 0;
        
        int count = 0;

        if (Character.isUpperCase(current.letter))
            count += 1;

        count += capitalLetterCount(current.leftChild);
        count += capitalLetterCount(current.rightChild);
        
        return count;
    }

    public String skipVowel() {
        return skipVowel(root);
    }

    private String skipVowel(Node current) {
        if (current == null)
            return "";

        String constonants = "";

        if (!isVowel(current.letter)) 
            constonants += current.letter;
        
        System.out.println(current.letter + "= vowel? " + isVowel(current.letter));
        System.out.println("constonants so far: " + constonants);

        return constonants + skipVowel(current.leftChild) + skipVowel(current.rightChild);
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
                return true;
            case 'e':
                return true;
            case 'i':
                return true;
            case 'o':
                return true;
            case 'u':
                return true;
            default:
                return false;
        }
    }
    
}
