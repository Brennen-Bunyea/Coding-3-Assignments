import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main (String[] args)
    {
        int [] arr = generate_random_unique(1, 20, 10);
        System.out.println("Generated array: " + Arrays.toString(arr));

        int target1 = 5;
        boolean foundInScan = Scan.scan(arr, target1);
        System.out.println("Scan for " + target1 + ": " + foundInScan);

        int target2 = 13;
        boolean foundInStor = Stor.storCheck(arr, target2);
        System.out.println("Stor for " + target2 + ": " + foundInStor);
    }

    //generates a random array of all unique numbers
    public static int[] generate_random_unique(int start, int end, int total)
    {
        int range = end - start + 1;

        //checks to make sure the array generated properly
        if(total > range)
        {
            System.out.println("Error");
            return new int[0];
        }

        //new ArrayList to store the ints
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        //places the numbers into the ArrayList
        for(int i = start; i <= end; i++)
        {
            numbers.add(i);
        }

        //shuffles the array
        Collections.shuffle(numbers);
        int[] result = new int[total];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = numbers.get(i);
        }
        return result;
    }
}