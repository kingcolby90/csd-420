//Colby king assignment 4.2 august 083125

import java.util.LinkedList;
import java.util.Collections;

public class LinkedListComparison {

    public static void main(String[] args) {
        runTraversalTest(50_000);
        System.out.println("====================================");
        runTraversalTest(500_000);
    }

    private static void runTraversalTest(int size) {
        System.out.println("Testing LinkedList traversal with " + size + " elements...");

        LinkedList<Integer> list = new LinkedList<>();
        Collections.addAll(list, generateData(size));

        long startForEach = System.nanoTime();
        for (int value : list) {
        }
        long endForEach = System.nanoTime();
        long timeForEach = (endForEach - startForEach) / 1_000_000;
        System.out.println("For-each (iterator) traversal time: " + timeForEach + " ms");

        long startGet = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endGet = System.nanoTime();
        long timeGet = (endGet - startGet) / 1_000_000;
        System.out.println("get(index) traversal time: " + timeGet + " ms");
    }

    private static Integer[] generateData(int size) {
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
        return data;
    }
}