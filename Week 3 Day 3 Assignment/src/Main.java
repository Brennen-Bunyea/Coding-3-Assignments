public class Main {
    public static void main(String[] args)
    {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int[]result = matrixSearch(arr, 5);
        System.out.println("[" + result[0] + ", " + result [1] + "]");
    }

    public static int[] matrixSearch(int[][] arr, int target)
    {
        int rows = arr.length;
        int cols = arr[0].length;

        //start at the top row
        int r = 0;
        //start at the last column
        int c = 0;

        while(r < rows && c >= 0)
        {
            if(arr[r][c] == target)
            {
                //found the target
                return new int[]{r, c};
            }
            else if(arr[r][c] > target)
            {
                //move to the left
                c--;
            }
            else
            {
                //move down
                r++;
            }
        }
        //the target wasn't found
        return new int[]{-1, -1};
    }
}