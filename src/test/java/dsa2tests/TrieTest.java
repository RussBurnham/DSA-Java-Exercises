package dsa2tests;

import dsa2.Trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TrieTest {

    private Trie trie;

    @BeforeEach
    public void setUp() {
        trie = new Trie();
    }

    @Test
    public void testInsertAndContains() {
        trie.insert("car");
        trie.insert("care");
        trie.insert("card");

        assertTrue(trie.contains("car"));
        assertTrue(trie.contains("care"));
        assertTrue(trie.contains("card"));
        assertFalse(trie.contains("cart"));
        assertFalse(trie.contains("ca"));
    }

    @Test
    public void testRemove() {
        trie.insert("car");
        trie.insert("care");

        assertTrue(trie.contains("car"));
        assertTrue(trie.contains("care"));

        trie.remove("car");

        assertFalse(trie.contains("car"));
        assertTrue(trie.contains("care"));
    }

    @Test
    public void testRemoveNonExistingWord() {
        trie.insert("car");
        trie.remove("care");

        assertTrue(trie.contains("car"));
        assertFalse(trie.contains("care"));
    }

    @Test
    public void testFindWordsWithPrefix() {
        trie.insert("car");
        trie.insert("care");
        trie.insert("card");
        trie.insert("cat");

        List<String> results = trie.findWords("car");

        assertTrue(results.contains("car"));
        assertTrue(results.contains("care"));
        assertTrue(results.contains("card"));
        assertFalse(results.contains("cat"));
    }

    @Test
    public void testCountWords() {
        trie.insert("hello");
        trie.insert("hi");
        trie.insert("hill");

        assertEquals(3, trie.countWords());

        trie.remove("hi");
        assertEquals(2, trie.countWords());
    }

    @Test
    public void testLongestCommonPrefix() {
        var trieFl = new Trie();
        trieFl.insert("flower");
        trieFl.insert("flow");
        trieFl.insert("flight");
        String[] words = { "flower", "flow", "flight" };
        String prefix = trieFl.longestCommonPrefix(words);
        assertEquals("fl", prefix);

        var trieIdentical = new Trie();
        trieIdentical.insert("test");
        String[] identical = { "test", "test", "test" };
        assertEquals("test", trieIdentical.longestCommonPrefix(identical));

        var trieNoCommonPrefix = new Trie();
        trieNoCommonPrefix.insert("dog");
        trieNoCommonPrefix.insert("racecar");
        trieNoCommonPrefix.insert("car");
        String[] noCommon = { "dog", "racecar", "car" };
        assertEquals("", trie.longestCommonPrefix(noCommon));
    }
}
