class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0, r = rows * cols - 1;

        // O(log(n * m)), as we hace n * m elements in total
        while (l <= r) {
            int m = l + (r - l) / 2;

            int row = m / cols;
            int col = m % cols;

            if (matrix[row][col] > target) r = m - 1;
            else if (matrix[row][col] < target) l = m + 1;
            else return true;
        }

        return false;
    }
}

// Time complexity: O(log(n * m))
// Space complexity: O(1)


/*

Test

Case 1:

[0, 1, 2]
[3, 4, 5]
[6, 7, 8]

target = 7

rows = 3, cols = 3
l = 0 -> 5 -> 7
r = 8
m = 4 -> 6 -> 7
row = 1 -> 2 -> 2
col = 1 -> 0 -> 1

return true

Case 2:

[0, 1, 2]
[3, 4, 5]
[6, 7, 8]

target = 9

rows = 3, cols = 3
l = 0 -> 5 -> 7 -> 8 -> 9
r = 8
m = 4 -> 6 -> 7 -> 8
row = 1 -> 2 -> 2 -> 2
col = 1 -> 0 -> 1 -> 2

return false

Case 3:
[1] target = 1

rows = 1, cols = 1
l = 0
r = 0
m = 0
row = 0
col = 0

return true



*/

/*
Same complexity, but less optimal approach


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

*/
