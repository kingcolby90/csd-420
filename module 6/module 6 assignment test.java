/*Colby king modle 6 assignment */
import java.util.Comparator;

public class BubbleSortTest {

    public static void main(String[] args) {
        // Test with Integer array using Comparable
        Integer[] numbers = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};
        System.out.println("Before sorting (Comparable):");
        BubbleSort.printArray(numbers);
        BubbleSort.bubbleSort(numbers);
        System.out.println("After sorting (Comparable):");
        BubbleSort.printArray(numbers);

        // Test with String array using Comparator
        String[] words = {"banana", "apple", "pear", "orange", "grape"};
        System.out.println("\nBefore sorting (Comparator):");
        BubbleSort.printArray(words);
        BubbleSort.bubbleSort(words, Comparator.naturalOrder());
        System.out.println("After sorting (Comparator):");
        BubbleSort.printArray(words);
    }
}

