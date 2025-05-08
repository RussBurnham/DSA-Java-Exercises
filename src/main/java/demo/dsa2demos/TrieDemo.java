package demo.dsa2demos;

import dsa2.Trie;
import demo.DemoUtil;
import demo.Runnable;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TrieDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        DemoUtil.printHeader("Trie");
        Trie trie = new Trie();

        Map<String, Runnable> trieMenu = new LinkedHashMap<>();

        trieMenu.put("insert(String word)", () -> {
            while (true) {
                String a = DemoUtil.getUserInput("\nInsert word or leave blank to EXIT>", scanner);
                if (a.isBlank())
                    break;
                trie.insert(a);
                System.out.println();
                System.out.println(trie.toString());
            }
        });

        trieMenu.put("remove(String word)", () -> {
            String b = DemoUtil.getUserInput("\nEnter word to remove> ", scanner);
            trie.remove(b);
            System.out.println();
            System.out.println(trie.toString());
        });

        trieMenu.put("countWords()", () -> {
            System.out.println("\nWord count: " + trie.countWords());
        });

        trieMenu.put("contains(String word)", () -> {
            String c = DemoUtil.getUserInput("Enter word> ", scanner);
            System.out.println("\nDoes Trie contain " + c + "? " + trie.contains(c));
        });

        trieMenu.put("findWords(String prefix)", () -> {
            String d = DemoUtil.getUserInput("\nEnter prefix> ", scanner);
            System.out.println("\nWords:");
            System.out.println(trie.findWords(d));
        });

        trieMenu.put("longestCommonPrefix(String[] words)", () -> {
            System.out.println("\nCreating a String[] of words (3 for this demo):");
            String e = DemoUtil.getUserInput("\nEnter first word> ", scanner);
            String f = DemoUtil.getUserInput("\nEnter second word> ", scanner);
            String g = DemoUtil.getUserInput("\nEnter third word> ", scanner);
            String[] mno = { e, f, g };
            System.out.println("\nLongest common prefix: " + trie.longestCommonPrefix(mno));
        });

        trieMenu.put("toString()", () -> {
            System.out.println("\nTrie: ");
            System.out.println(trie.toString());
        });

        DemoUtil.runMenu("Trie methods", trieMenu);
    }
}
