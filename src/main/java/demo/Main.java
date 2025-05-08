package demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\nChoose a DSA module to run:");
            System.out.println("\n\n1 - DSA1 (Arrays, LinkedLists, Queues, Stacks, HashTable)");
            System.out.println("\n2 - DSA2 (Trees, Graphs, Heaps, Trie)");
            System.out.println("\n3 - DSA3 (SearchUtil, SortUtil, StringUtil)");
            System.out.println("\nEnter number of choice to SELECT or any other key to EXIT>");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    DSA1Runner dsa1 = new DSA1Runner();
                    dsa1.run();
                    break;
                case "2":
                    DSA2Runner dsa2 = new DSA2Runner();
                    dsa2.run();
                    break;
                case "3":
                    DSA3Runner dsa3 = new DSA3Runner();
                    dsa3.run();
                    break;
                default:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
            }
        }
    }
}