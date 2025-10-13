import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = n;
        }

        //shell sort
        long startShell = System.currentTimeMillis();
        int[] shellSorted = ShellSort.sort(numbers);
        long endShell = System.currentTimeMillis();

        //quick sort
        long startQuick = System.currentTimeMillis();
        int[] quickSorted = ShellSort.sort(numbers);
        long endQuick = System.currentTimeMillis();

        System.out.println("Shell Sort time: " + (endShell - startShell) + " ms");
        System.out.println("Quick Sort time: " + (endQuick - startQuick) + " ms");
    }
}