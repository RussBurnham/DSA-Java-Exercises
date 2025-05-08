package dsa2tests;

import dsa2.Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class TreeTest {
    private Tree tree;

    @BeforeEach
    void setUp() {
        tree = new Tree(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(17);
    }

    @Test
    void testInsertAndFind() {
        assertTrue(tree.find(5));
        assertTrue(tree.find(17));
        assertFalse(tree.find(100));
    }

    @Test
    void testContains() {
        assertTrue(tree.contains(3));
        assertFalse(tree.contains(99));
    }

    @Test
    void testHeight() {
        assertEquals(2, tree.height());
    }

    @Test
    void testMin() {
        assertEquals(3, tree.min());
    }

    @Test
    void testMax() {
        assertEquals(17, tree.max());
    }

    @Test
    void testEquals() {
        Tree anotherTree = new Tree(10);
        anotherTree.insert(5);
        anotherTree.insert(15);
        anotherTree.insert(3);
        anotherTree.insert(7);
        anotherTree.insert(12);
        anotherTree.insert(17);

        assertTrue(tree.equals(anotherTree));

        anotherTree.insert(100);
        assertFalse(tree.equals(anotherTree));
    }

    @Test
    void testIsBinarySearchTree() {
        assertTrue(tree.isBinarySearchTree());
    }

    @Test
    void testGetNodesAtDistance() {
        List<Integer> nodes = tree.getNodesAtDistance(2);
        assertTrue(nodes.containsAll(List.of(3, 7, 12, 17)));
    }

    @Test
    void testSize() {
        assertEquals(7, tree.size());
    }

    @Test
    void testCountLeaves() {
        assertEquals(4, tree.countLeaves());
    }

    @Test
    void testAreSiblings() {
        assertTrue(tree.areSiblings(5, 15));
        assertTrue(tree.areSiblings(3, 7));
        assertFalse(tree.areSiblings(3, 15));
    }

    @Test
    void testGetAncestors() {
        List<Integer> ancestors = tree.getAncestors(7);
        assertEquals(List.of(5, 10), ancestors);
    }

    @Test
    void testIsBalanced() {
        assertTrue(tree.isBalanced());
    }

    @Test
    void testIsPerfect() {
        assertTrue(tree.isPerfect());

        Tree inPerfectTree = new Tree(10);
        inPerfectTree.insert(5);
        inPerfectTree.insert(4);
        inPerfectTree.insert(3);
        inPerfectTree.insert(7);
        inPerfectTree.insert(12);
        inPerfectTree.insert(17);

        assertFalse(inPerfectTree.isPerfect());
    }
}
