package edu.galileo;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsDemo {

    public List<Integer> generateRandomList() {
        List<Integer> numbersList = new ArrayList<>();
        Random rGenerator = new Random();
        // Add random number to the list
        for (int i = 0; i < 20; i++) {
            numbersList.add(rGenerator.nextInt(255));
        }
        return numbersList;
    }

    public void oldSort() {
        List<Integer> theList = generateRandomList();
        System.out.println("\nUnsorted List: " + theList);

        // Sorting in the old way
        Collections.sort(theList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("Sorted in old way: " + theList);
    }

    public void lambdaSort() {
        List<Integer> theList = generateRandomList();
        System.out.println("\nUnsorted List: " + theList);
        theList.sort((x,y)->x.compareTo(y));
        System.out.println("Sorted in lambda way: " + theList);
    }

    public void anotherSort() {
        List<Integer> theList = generateRandomList();
        System.out.println("\nUnsorted List: " + theList);
        theList.sort(Comparator.naturalOrder());
        System.out.println("Sorted on my way: " + theList);
    }

    public void oldFilter() {
        List<Integer> unfilteredList = generateRandomList();
        List<Integer> filteredList = new ArrayList<>();
        System.out.println("\nUnfiltered List: " + unfilteredList);
        for (Integer number : unfilteredList) {
            if (number > 50) {
                filteredList.add(number);
            }
        }
        System.out.println("Filtered list in old way: " + filteredList);
    }

    public void lambdaFilter() {
        List<Integer> unfilteredList = generateRandomList();
        System.out.println("\nUnfiltered List: " + unfilteredList);
        List<Integer> filteredList = unfilteredList.stream()
                .filter(x -> x > 50)
                .collect(Collectors.toList());
        System.out.println("Filtered list in lambda way: " + filteredList);
    }

    public static void main(String[] args) {
        StreamsDemo mainInstance = new StreamsDemo();
        // Sorting demo
        mainInstance.oldSort();
        mainInstance.lambdaSort();
        mainInstance.anotherSort();
        // Filtering demo
        mainInstance.oldFilter();
        mainInstance.lambdaFilter();
    }
}
