/* Colby King module 6 Assignment */

import java.util.Comparator;

public class BubbleSort {


    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    System.out.println("Swap made (Comparable)");
                }
            }
        }
    }

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    System.out.println("Swap made (Comparator)");
                }
            }
        }
    }

    public static <E> void printArray(E[] array) {
        System.out.print("Array = { ");
        for (E item : array) {
            System.out.print(item + " ");
        }
        System.out.println("}");
    }
}