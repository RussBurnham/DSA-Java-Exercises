package dsa2tests;

import dsa2.AVLTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class AVLTreeTest {

    private AVLTree tree;

    @BeforeEach
    void setup() {
        tree = new AVLTree();
    }
    
    @Test
    public void testSingleInsert() {
        tree.insert(10);
        assertEquals(10, tree.getRootValue());
    }

    @Test
    public void testLeftRotation() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(30); 
        assertEquals(20, tree.getRootValue()); 
    }

    @Test
    public void testRightRotation() {
        tree.insert(30);
        tree.insert(20);
        tree.insert(10); 
        assertEquals(20, tree.getRootValue()); 
    }

    @Test
    public void testLeftRightRotation() {
        tree.insert(30);
        tree.insert(10);
        tree.insert(20); 
        assertEquals(20, tree.getRootValue());
    }

    @Test
    public void testRightLeftRotation() {
        tree.insert(10);
        tree.insert(30);
        tree.insert(20); 
        assertEquals(20, tree.getRootValue());
    }

    @Test
    public void testHeightandBalance() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        Map<Integer, AVLTree.NodeInfo> properties = tree.validateAVLTreeProperties();
        assertEquals(0, properties.get(10).getHeight());
        assertEquals(0, properties.get(10).getBalance());
        assertEquals(1, properties.get(20).getHeight());
        assertEquals(0, properties.get(20).getBalance());
        assertEquals(0, properties.get(30).getHeight());
        assertEquals(0, properties.get(30).getBalance());
    }
    

}
