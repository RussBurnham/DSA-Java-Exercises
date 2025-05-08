package dsa2tests;

import dsa2.Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

class GraphTest {

    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
    }

    @Test
    void testAddNode() {
        graph.addNode("E");
        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            graph.print();

            String output = outputStream.toString().trim();
            assertTrue(output.contains("E"));

        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testRemoveNode() {
        graph.removeNode("D");
        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            graph.print();

            String output = outputStream.toString().trim();
            assertFalse(output.contains("D"));

        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    void testAddAndRemoveEdge() {
        graph.addEdge("A", "B");
        graph.removeEdge("A", "B");
    }

    @Test
    void testTopologicalSort() {
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("A", "C");

        List<String> result = graph.topologicalSort();
        assertTrue(result.indexOf("A") < result.indexOf("B"));
        assertTrue(result.indexOf("B") < result.indexOf("C"));
    }

    @Test
    void testHasCycleFalse() {
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        assertFalse(graph.hasCycle());
    }

    @Test
    void testHasCycleTrue() {
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A"); 
        assertTrue(graph.hasCycle());
    }

    @Test
    void testDepthFirstIterativeDoesNotCrash() {
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.depthFirstIterative("A"); 
    }

    @Test
    void testDepthFirstRecursiveDoesNotCrash() {
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.depthFirstRecursive("A");
    }

    @Test
    void testBreadthFirstDoesNotCrash() {
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.traverseBreadthFirst("A");
    }
}
