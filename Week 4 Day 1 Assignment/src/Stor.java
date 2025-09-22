import java.util.*;

public class Stor
{
    //method to tell if target is in the array
     public static boolean storCheck(int [] input, int target)
     {
         int min = input[0];
         int max = input[0];

         // Find min and max
         for (int i = 0; i < input.length; i++)
         {
             int num = input[i];
             if (num < min)
             {
                 min = num;
             }
             if (num > max)
             {
                 max = num;
             }
         }

         //creates new array of the correct size from min and max
         int[] present = new int[max - min + 1];

         //check if it is present
         for (int i = 0; i < input.length; i++)
         {
             int num = input[i];
             //shift index
             present[num - min] = 1;
         }

         System.out.println("Present array: " + Arrays.toString(present));

         //check if target is in range and present
         if(target >= 0 && target <= max && present[target - min] == 1)
         {
             //the target was found
             return true;
         }
         else
         {
             //target wasn't found
             return false;
         }
     }
}
