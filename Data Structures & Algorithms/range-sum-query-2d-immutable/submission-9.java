class NumMatrix {

    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.prefix = new int[m + 1][n + 1];

        for (int r = 0; r < m; r++) {

            int total = 0;
            
            for (int c = 0; c < n; c++) {
                total += matrix[r][c];
                int above = prefix[r][c + 1];
                this.prefix[r + 1][c + 1] = total + above;
            }
        }   

    }

    /*
    1 2 3
    4 5 6
    7 8 9

    1 3 6
    5 12 21
    12 27 45
    
    */
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;

        // currentarea - above area - leftarea + common

        int totalArea = prefix[row2][col2];
        int aboveArea = prefix[row1 - 1][col2];
        int leftArea = prefix[row2][col1 - 1];
        int commonArea = prefix[row1 - 1][col1 - 1];

        int res = totalArea - aboveArea - leftArea + commonArea;

        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */