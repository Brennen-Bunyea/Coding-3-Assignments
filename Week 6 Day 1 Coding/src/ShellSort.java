import java.util.Arrays;

public class ShellSort
{
    //Shell sort with automatically calculated intervals
    public static int[] sort(int[] arr)
    {
        int[] sorted = Arrays.copyOf(arr, arr.length);

        //we have to find the value of n where 2^n < arr.length <= 2^(n + 1)
        int n = 1;
        while(Math.pow(2, n + 1) < arr.length)
        {
            n++;
        }

        //build the intervals
        int[] intervals = new int[n + 1];
        for(int i = 0; i < n; i++)
        {
            intervals[i] = (int) Math.pow(2, n - i);
        }
        intervals[n] = 1;

        //apply the insertion sort on each interval
        for(int i = 1; i < intervals.length; i++)
        {
            int gap = intervals[i];
            for(int start = 0; start < gap; start++)
            {
                InsertionSort.insertionSortSection(sorted, start, gap);
            }
        }
        return sorted;
    }
}
