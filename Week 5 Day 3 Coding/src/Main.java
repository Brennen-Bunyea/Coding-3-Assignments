import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Size: ");
        int size = input.nextInt();

        //what values are allowed
        int start = 1;
        int end = 100000;

        //generate random array
        int[] arr1 = ArrayGenerator.randomArray(size, start, end);
        //makes a copy of that array
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        //measure bubbleSort time
        long startTime = System.currentTimeMillis();
        Sort.bubbleSort(arr1);
        long endTime = System.currentTimeMillis();
        long bubbleTime = endTime - startTime;

        //measure selectionSort time
        startTime = System.currentTimeMillis();
        Sort.selectionSort(arr2);
        endTime = System.currentTimeMillis();
        long selectionTime = endTime - startTime;

        //measure insertionSort time
        startTime = System.currentTimeMillis();
        Sort.insertionSort(arr3);
        endTime = System.currentTimeMillis();
        long insertionTime = endTime - startTime;

        //print results
        System.out.println("> Sorting a random array size of " + size + " took Bubble Sort " + bubbleTime + "ms to complete.");
        System.out.println("> Sorting a random array of size " + size + " took Selection Sort " + selectionTime + "ms to complete.");
        System.out.println("> Sorting a random array of size " + size + " took Insertion Sort " + insertionTime + "ms to complete.");
    }
}