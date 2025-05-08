package dsa3tests;

import dsa3.StringUtil;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilTest {

    @Test
    public void testCountVowels() {
        assertEquals(5, StringUtil.countVowels("aeiou"));
        assertEquals(5, StringUtil.countVowels("AEIOU"));
        assertEquals(0, StringUtil.countVowels("xyz"));
        assertEquals(0, StringUtil.countVowels(null));
    }

    @Test
    public void testReverseString() {
        assertEquals("dcba", StringUtil.reverseString("abcd"));
        assertEquals("", StringUtil.reverseString(null));
        assertEquals("", StringUtil.reverseString(""));
        assertEquals("a", StringUtil.reverseString("a"));
    }

    @Test
    public void testReverseWords() {
        assertEquals("world hello", StringUtil.reverseWords("hello world"));
        assertEquals("", StringUtil.reverseWords(null));
        assertEquals("world hello", StringUtil.reverseWords("   hello   world   "));
        assertEquals("one", StringUtil.reverseWords("one"));
    }

    @Test
    public void testIsRotation() {
        assertTrue(StringUtil.isRotation("ABCD", "CDAB"));
        assertFalse(StringUtil.isRotation("ABCD", "ACBD"));
        assertFalse(StringUtil.isRotation("AB", null));
        assertFalse(StringUtil.isRotation(null, "AB"));
    }

    @Test
    public void testRemoveDuplicates() {
        assertEquals("abcd", StringUtil.removeDuplicates("aabbccdd"));
        assertEquals("abc", StringUtil.removeDuplicates("abc"));
        assertEquals("", StringUtil.removeDuplicates(null));
    }

    @Test
    public void testMostRepeatedChar() {
        assertEquals('a', StringUtil.mostRepeatedChar("aabbcccaaa"));
        assertEquals(' ', StringUtil.mostRepeatedChar(""));
        assertEquals(' ', StringUtil.mostRepeatedChar(null));
    }

    @Test
    public void testCapitalizeFirstLetters() {
        assertEquals("Hello World", StringUtil.capitalizeFirstLetters("hello world"));
        assertEquals("Hello", StringUtil.capitalizeFirstLetters("  hello  "));
        assertEquals("", StringUtil.capitalizeFirstLetters(null));
        assertEquals("", StringUtil.capitalizeFirstLetters("     "));
    }

    @Test
    public void testIsAnagram2() {
        assertTrue(StringUtil.isAnagram2("DebitCard", "BadCredit"));
        assertFalse(StringUtil.isAnagram2("apple", "papelz"));
        assertFalse(StringUtil.isAnagram2("apple", "applf"));
        assertFalse(StringUtil.isAnagram2(null, "test"));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtil.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(StringUtil.isPalindrome("hello"));
        assertFalse(StringUtil.isPalindrome(null));
        assertFalse(StringUtil.isPalindrome("   "));
    }
}
