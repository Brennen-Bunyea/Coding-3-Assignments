import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = MatrixSearch.matrixSearch(arr, n);
        if (result[0] == -1) {
            System.out.println("Target not found.");
        }
        else
        {
            System.out.println("Target: " + "[" + result[0] + "," + result[1] + "]");
        }
    }
}