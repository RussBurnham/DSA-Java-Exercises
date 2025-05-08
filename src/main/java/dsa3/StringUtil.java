package dsa3;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class StringUtil {

    public static int countVowels(String string) {
        if (string == null)
            return 0;

        String vowels = "aeiouAEIOU";

        Set<Character> vowelSet = new HashSet<>();
        for (char v : vowels.toCharArray())
            vowelSet.add(v);

        int count = 0;
        for (char c : string.toCharArray())
            if (vowelSet.contains(c))
                count++;

        return count;
    }

    public static String reverseString(String string) {
        if (string == null)
            return "";

        char[] chars = string.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            char temp = chars[j];
            chars[j--] = chars[i];
            chars[i++] = temp;
        }

        return String.valueOf(chars);
    }

    public static String reverseWords(String sentence) {
        if (sentence == null)
            return "";

        String[] words = sentence
                            .trim()
                            .replaceAll("\\s+", " ")
                            .split(" ");

        int i = 0;
        int j = words.length - 1;

        while (i < j) {
            String temp = words[j];
            words[j--] = words[i];
            words[i++] = temp;
        }

        return String.join(" ", words);
    }

    public static boolean isRotation(String first, String second) {
        if (first == null || second == null)
            return false;

        return (first.length() == second.length() &&
                first.concat(first).contains(second));
    }

    public static String removeDuplicates(String string) {
        if (string == null)
            return "";

        Set<Character> visited = new HashSet<>();
        StringBuilder output = new StringBuilder();

        for (var ch : string.toCharArray()) {
            if (!visited.contains(ch)) {
                visited.add(ch);
                output.append(ch);
            }
        }

        return output.toString();
    }

    public static char mostRepeatedChar(String string) {
        if (string == null || string.isEmpty())
            return ' ';

        final int ASCII_SIZE = 128;

        int[] ascii = new int[ASCII_SIZE];

        int count = 0;
        char mostRepeated = string.charAt(0);

        for (var ch : string.toCharArray()) {
            ascii[ch]++;
            if (ascii[ch] > count) {
                count = ascii[ch];
                mostRepeated = ch;
            }
        }

        return mostRepeated;
    }

    public static String capitalizeFirstLetters(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
            return "";

        var words = sentence
                .trim()
                .replaceAll("\\s+", " ")
                .split(" ");

        for (int i = 0; i < words.length; i++) {
            String firstLetter = words[i].substring(0, 1).toUpperCase();
            String rest = words[i].substring(1).toLowerCase();
            words[i] = firstLetter + rest;
        }

        return String.join(" ", words);
    }

    public static boolean isAnagram(String first, String second) {
        if (first == null || second == null)
            return false;

        var firstArray = first.toLowerCase().toCharArray();
        Arrays.sort(firstArray);

        var secondArray = second.toLowerCase().toCharArray();
        Arrays.sort(secondArray);

        return Arrays.equals(firstArray, secondArray);
    }

    public static boolean isAnagram2(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            return false;

        final int ALPHABET_SIZE = 26;

        int[] frequencies = new int[ALPHABET_SIZE];

        first = first.toLowerCase();
        for (int i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++;

        second = second.toLowerCase();
        for (int i = 0; i < second.length(); i++) {
            int index = second.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;

            frequencies[index]--;
        }

        return true;
    }

    public static boolean isPalindrome(String string) {
        if (string == null || string.trim().isEmpty())
            return false;

        string = string.toLowerCase().replaceAll("[^a-z0-9]", "");

        int i = 0;
        int j = string.length() - 1;

        while (i < j)
            if (string.charAt(i++) != string.charAt(j--))
                return false;

        return true;
    }
}
