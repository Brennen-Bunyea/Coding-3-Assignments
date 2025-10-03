public class Sort
{
    public static void bubbleSort(int[] random)
    {
        boolean swapped;
        for (int i = 0; i < random.length - 1; i++)
        {
            swapped = false;
            for(int j = 0; j < random.length - i - 1; j++)
            {
                if(random[j] > random[j + 1])
                {
                    //swaps the values
                    int temp = random[j];
                    random[j] = random[j + 1];
                    random[j + 1] = temp;
                    swapped = true;
                }
            }
            //the array is already sorted
            if(!swapped)
                break;
        }
    }

    public static void selectionSort(int[] random)
    {
        //walks through string
        for(int i = 1; i < random.length - 1; i++)
        {
            int minIndex = i;
            //checks to see if the current lowest number is still the lowest number
            for(int j = i + 1; j < random.length; j++)
            {
                if(random[j] < random[minIndex])
                {
                    minIndex = j;
                }
            }
            //inserts the value
            int temp = random[i];
            random[i] = random[minIndex];
            random[minIndex] = temp;
        }
    }

    //the method to perform insertion sort
    public static void insertionSort(int[] arr)
    {
        for(int i = 1; i < arr.length; i++)
        {
            //move the elements that are greater than the key position to the correct spot
            int key = arr[i];
            int j = i - 1;

            //while loop to move the elements that are greater than the key to the correct spot
            while(j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }

            //place the key into the correct location
            arr[j + 1] = key;
        }
    }
}
