class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows - 1;

        while (l <= r) {
            
            int m = l + (r - l) / 2;

            if (matrix[m][cols - 1] < target) l = m + 1;
            else if (matrix[m][cols - 1] > target) r = m - 1;
            else return true;
        }

        if (l > rows - 1) return false;

        int targetRow = l;
        l = 0;
        r = cols - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (matrix[targetRow][m] < target) l = m + 1;
            else if (matrix[targetRow][m] > target) r = m - 1;
            else return true;
        }

        return false;


    }
}
