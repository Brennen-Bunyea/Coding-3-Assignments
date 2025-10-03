import java.util.*;

public class ArrayGenerator
{
    public static int[] randomArray(int size, int start, int end)
    {
        //declares the new int[] and a new Random
        int[] random = new int[size];
        Random rand = new Random();

        //walks through and sets each value to a random int
        for(int i = 0; i < size; i++)
        {
            random[i] = rand.nextInt(end - start + 1) + start;
        }
        return random;
    }
}