import java.util.Arrays;

public class ShellSort
{
    public static int[] sort(int[] arr)
    {
        int[] sorted = Arrays.copyOf(arr, arr.length);

        //find the value of n where 2^n < arr.length <= 2^(n + 1)
        int n = 1;
        while (Math.pow(2, n + 1) < arr.length)
        {
            n++;
        }

        //build the intervals
        int[] intervals = new int[n + 1];
        for (int i = 0; i < n; i++)
        {
            intervals[i] = (int) Math.pow(2, n - i);
        }
        intervals[n] = 1;

        //apply insertion sort
        for (int gap : intervals)
        {
            for (int start = 0; start < gap; start++)
            {
                insertionSort(sorted, start, gap);
            }
        }

        return sorted;
    }

    //internal insertion sort
    private static void insertionSort(int[] arr, int start, int gap)
    {
        for (int i = start + gap; i < arr.length; i += gap)
        {
            int key = arr[i];
            int j = i - gap;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + gap] = arr[j];
                j -= gap;
            }
            arr[j + gap] = key;
        }
    }
}