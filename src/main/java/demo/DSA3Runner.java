package demo;

import demo.dsa3demos.*;

import java.util.Scanner;
import java.util.Map;

public class DSA3Runner implements Runnable {
    Scanner scanner = new Scanner(System.in);

    SearchDemo search = new SearchDemo();
    SortDemo sort = new SortDemo();
    StringDemo string = new StringDemo();

    @Override
    public void run() {
        Map<String, Runnable> dsa3Map = Map.of(
            "Search algorithms", search::run,
            "Sort algorithms", sort::run,
            "String algorithms", string::run       
        );

        DemoUtil.runMenu("DSA3 Algorithms", dsa3Map);
    }                   
}
