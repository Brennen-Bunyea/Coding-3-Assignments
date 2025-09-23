import java.util.*;

public class MatrixSearch
{
    public static int[] matrixSearch(int[][] arr, int target)
    {
        int rows = arr.length;
        int cols = arr[0].length;

        //start row
        int left = 0;
        //start column
        int right = rows * cols - 1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;

            if(arr[row][col] == target)
            {
                //target was found
                return new int[]{row, col};
            }
            else if(arr[row][col] < target)
            {
                //search right half
                left = mid + 1;
            }
            else
            {
                //search left half
                right = mid - 1;
            }
        }
        //target was not found
        return new int[]{-1, -1};
    }
}