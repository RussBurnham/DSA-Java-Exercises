package dsa2tests;

import dsa2.WeightedGraph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeightedGraphTest {
    private WeightedGraph graph;

    @BeforeEach
    void setUp() {
        graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
    }

    @Test
    void testAddEdge() {
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 3);

        assertTrue(graph.containsNode("A"));
        assertTrue(graph.containsNode("B"));
        assertTrue(graph.containsNode("C"));
        assertTrue(graph.containsNode("D"));
    }

    @Test
    void testAddEdge_InvalidNode() {
        graph.addEdge("A", "Z", 5);
        assertEquals(0, graph.getShortestPath("A", "Z").size());
    }

    @Test
    void testGetShortestDistance() {
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 3);
        graph.addEdge("A", "C", 10);

        var result = graph.getShortestDistance("A", "C");
        assertNotNull(result);
        assertEquals(8, result.getDistance());
    }

    @Test
    void testGetShortestPath() {
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 3);
        graph.addEdge("A", "C", 10);

        var path = graph.getShortestPath("A", "C");
        assertNotNull(path);
        assertEquals(3, path.size());
        assertEquals("A", path.get(0).toString());
        assertEquals("C", path.get(2).toString());
    }

    @Test
    void testHasCycle() {
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 3);
        graph.addEdge("C", "A", 2);

        assertTrue(graph.hasCycle());
    }

    @Test
    void testGetMinimumSpanningTree() {
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 3);
        graph.addEdge("C", "D", 2);
        graph.addEdge("A", "D", 1);

        WeightedGraph mst = graph.getMinimumSpanningTree();
        assertNotNull(mst);
        assertTrue(mst.containsNode("A"));
        assertTrue(mst.containsNode("B"));
        assertTrue(mst.containsNode("C"));
        assertTrue(mst.containsNode("D"));
    }

    @Test
    void testPrintConnections() {
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 3);
        graph.addEdge("A", "C", 10);

        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            graph.printConnections();

            String output = outputStream.toString().trim();
            assertTrue(output.contains("A <---> B (5)"));
            assertTrue(output.contains("A <---> C (10)"));
            assertTrue(output.contains("B <---> C (3)"));

        } finally {
            System.setOut(originalOut);
        }
    }
}
