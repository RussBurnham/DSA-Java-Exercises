package demo;

import demo.dsa2demos.*;

import java.util.Map;
import java.util.Scanner;

public class DSA2Runner implements Runnable {
    Scanner scanner = new Scanner(System.in);

    AVLTreeDemo aVLTree = new AVLTreeDemo();
    TreeDemo tree = new TreeDemo();
    GraphDemo graph = new GraphDemo();
    WeightedGraphDemo weightedGraph = new WeightedGraphDemo();
    MaxHeapDemo maxHeap = new MaxHeapDemo();
    MinHeapDemo minHeap = new MinHeapDemo();
    TrieDemo trie = new TrieDemo();

    @Override
    public void run() {
        Map<String, Runnable> dsa2Map = Map.of(
            "AVLTree", aVLTree::run,
            "Tree", tree::run,
            "Graph", graph::run,
            "WeightedGraph", weightedGraph::run,
            "MaxHeap", maxHeap::run,
            "MinHeap", minHeap::run,
            "Trie", trie::run
        );

        DemoUtil.runMenu("DSA2 Data Structures", dsa2Map);
    }
}
