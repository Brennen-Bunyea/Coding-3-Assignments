import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size: ");

        int size = sc.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = (int) (Math.random() * size * 10);
        }

        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Benchmark Results (milliseconds):");

        long t1Start = System.currentTimeMillis();
        ShellSort.sort(arr1);
        long t1End = System.currentTimeMillis();
        long t1 = t1End - t1Start;
        System.out.println("Insertion Sort: " + t1);

        long t2Start = System.currentTimeMillis();
        InsertionSort.sort(arr2);
        long t2End = System.currentTimeMillis();
        long t2 = t2End - t2Start;
        System.out.println("Shell Sort: " + t2);
    }
}