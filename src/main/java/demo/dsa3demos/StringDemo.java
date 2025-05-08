package demo.dsa3demos;

import dsa3.StringUtil;
import demo.DemoUtil;
import demo.Runnable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StringDemo implements Runnable {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
         DemoUtil.printHeader("StringUtil");
        
        Map<String, Runnable> stringMenu = new LinkedHashMap<>();

        stringMenu.put("countVowels", () -> {
            String a = DemoUtil.getUserInput("\nEnter a word> ", scanner);
            System.out.println("\nVowels: " + StringUtil.countVowels(a));
        });

        stringMenu.put("reverseString", () -> {
            String b = DemoUtil.getUserInput("\nEnter a word> ", scanner);
            System.out.println("\nReversed: " + StringUtil.reverseString(b));
        });

        stringMenu.put("isRotation", () -> {
            String c = DemoUtil.getUserInput("\nEnter first String> ", scanner);
            String d = DemoUtil.getUserInput("\nEnter second String> ", scanner);
            System.out.println("\nAre they a rotation? " +
                                StringUtil.isRotation(c, d));
        });

        stringMenu.put("removeDuplicates", () -> {
            String e = DemoUtil.getUserInput(
                "\nEnter a word or sentence with duplicate characters> ", scanner);
            System.out.println("\nDuplicates removed: " + StringUtil.removeDuplicates(e));
        });

        stringMenu.put("mostRepeatedChar", () -> {
            String f = DemoUtil.getUserInput(
                "\nEnter a word or sentence with duplicate characters> ", scanner);
            System.out.println("\nMost repeated character: "
                                + StringUtil.mostRepeatedChar(f));
        });

        stringMenu.put("capitalizeFirstLetters", () -> {
            String g = DemoUtil.getUserInput("\nEnter a sentence> ", scanner);
            System.out.println("\nCapitalized first letters: " +
                                StringUtil.capitalizeFirstLetters(g));
        });

        stringMenu.put("isAnagram", () -> {
            String h = DemoUtil.getUserInput("\nEnter first String> ", scanner);
            String i = DemoUtil.getUserInput("\nEnter second String> ", scanner);
            System.out.println("\nAre they an anagram? " + StringUtil.isAnagram2(h, i));
        });

        stringMenu.put("isPalindrome", () -> {
            String j = DemoUtil.getUserInput("\nEnter a word or sentence> ", scanner);
            System.out.println("\nIs " + j + " a palindrome? " + StringUtil.isPalindrome(j));
        });

        DemoUtil.runMenu("String methods", stringMenu);
    }
    
}
