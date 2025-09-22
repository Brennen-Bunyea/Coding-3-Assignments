import java.util.*;

public class Scan
{
    //linear search method to scan the array
    public static boolean scan(int[] input, int target)
    {
        //loop through the int[] and if we find the target, return true
        for(int i = 0; i < input.length; i++)
            {
            if(input[i] == target)
                return true;
            }
        //didn't find the target
        return false;
    }
}