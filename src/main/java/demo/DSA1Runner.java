package demo;

import demo.dsa1demos.*;

import java.util.Scanner;
import java.util.Map;

public class DSA1Runner implements Runnable {
    Scanner scanner = new Scanner(System.in);

    ArrayDemo array = new ArrayDemo();
    ArrayQueueDemo arrayQueue = new ArrayQueueDemo();
    HashTableDemo hashTable = new HashTableDemo();
    LinkedListDemo linkedList = new LinkedListDemo();
    LinkedListQueueDemo linkedListQueue = new LinkedListQueueDemo();
    PriorityQueueDemo priorityQueue = new PriorityQueueDemo();
    StackDemo stack = new StackDemo();
    QueueByStacksDemo queueByStacks = new QueueByStacksDemo();
    StackByQueuesDemo stackByQueues = new StackByQueuesDemo();

    @Override
    public void run() {
        Map<String, Runnable> dsa1Map = Map.of(
            "Array", array::run,
            "ArrayQueue", arrayQueue::run,
            "HashTable", hashTable::run,
            "LinkedList", linkedList::run,
            "LinkedListQueue", linkedListQueue::run,
            "PriorityQueue", priorityQueue::run,
            "Stack", stack::run,
            "QueueByStacks", queueByStacks::run,
            "StackByQueues", stackByQueues::run
        );

        DemoUtil.runMenu("DSA1 Data Structures", dsa1Map);
    }
}
