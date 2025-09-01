//Colby King assignment 3 082525

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        System.out.println("OriginalList:");
        System.out.println(originalList);

        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("\nList After Removing Duplicates:");
        System.out.println(uniqueList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        return new ArrayList<>(new HashSet<>(list));
    }

