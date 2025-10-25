import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Random rand = new Random();

        //benchmark for testing array sizes
        int[] sizes = {1000, 10000, 100000, 1000000};
        for(int i = 0; i < sizes.length; i++)
        {
            int size = sizes[i];
            int[] arr = new int[size];

            //fill the array with random values
            for(int j = 0; j < arr.length; j++)
            {
                arr[j] = rand.nextInt(1000000);
            }

            long start = System.currentTimeMillis();
            mergeSort(arr, 0, arr.length - 1);
            long end = System.currentTimeMillis();
            System.out.println("Size of: " + arr.length + "-->" + (end - start) + "ms");
        }
    }

    public static void mergeSort(int[] arr, int left, int right)
    {
        if (left < right)
        {
            int mid = left + (right - left) / 2;
            if (mid >= right)
            {
                return;
            }

            //logic for separating and merging
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right)
    {
        if (left < 0 || right >= arr.length || left >= right)
        {
            return; // Defensive check to prevent invalid access
        }

        int n1 = mid - left + 1;
        int n2 = right - mid;

        //no right have to merge
        if (mid + 1 > right)
        {
            return;
        }

        int[] L = new int[n1];
        int[] R = new int[n2];

        int i;
        for (i = 0; i < n1; i++)
        {
            L[i] = arr[left + i];
        }

        int j;
        for (j = 0; j < n2; j++)
        {
            if (mid + 1 + j < arr.length)
            {
                R[j] = arr[mid + 1 + j];
            }
        }

        i = 0;
        j = 0;
        int k = left;

        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}