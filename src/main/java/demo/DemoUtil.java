package demo;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoUtil {

    public static void printHeader(String title) {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nRunning " + title + " module...");
    }

    public static void runMenu(String title, Map<String, Runnable> map) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            slow();
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\n=== " + title + " ===");
            System.out.println();
            int option = 1;
            List<String> keys = new ArrayList<>(map.keySet());
            for (String key : keys)
                System.out.println((option++) + " - " + key);

            System.out.println("\nEnter number of choice to SELECT or any other key to EXIT>");
            String input = scanner.nextLine();

            try {
                int choice = Integer.parseInt(input);
                if (1 <= choice && choice <= keys.size()) {
                    map.get(keys.get(choice - 1)).run();
                } else {
                    System.out.println("\nExiting.");
                    break;
                }
            } catch (NumberFormatException e) {
                break;
            }
        }
    }

    public static String getUserInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getUserInt(String prompt, Scanner scanner) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        int num = Integer.parseInt(input);
        return num;
    }

    private static void slow() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
