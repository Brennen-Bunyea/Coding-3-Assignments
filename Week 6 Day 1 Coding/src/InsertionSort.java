import java.util.Arrays;

public class InsertionSort
{
    //method for insertion sort
    public static int[] sort(int[] arr)
    {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && sorted[j] > key) {
                sorted[j + 1] = sorted[j];
                j--;
            }
            sorted[j + 1] = key;
        }
        return sorted;
    }

    //method that helps with shell sort
    public static void insertionSortSection(int[] arr, int start, int gap)
    {
        for(int i = start + gap; i < arr.length; i += gap)
        {
            int current = arr[i];
            int j = i - gap;
            while(j >= 0 && arr[j] > current)
            {
                arr[j + gap] = arr[j];
                j -= gap;
            }
            arr[j + gap] = current;
        }
    }
}