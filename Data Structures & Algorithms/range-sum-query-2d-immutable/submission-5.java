class NumMatrix {

    int[][] prefix;
    int m;
    int n;

    public NumMatrix(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.prefix = new int[m + 1][n + 1];

        for (int r = 0; r < m; r++) {
            int sum = 0;
            for (int c = 0; c < n; c++) {
                int above = this.prefix[r][c + 1];
                this.prefix[r + 1][c + 1] = this.prefix[r + 1][c] + matrix[r][c] + above - this.prefix[r][c];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;

        int endArea = prefix[row2][col2];
        int leftArea = prefix[row2][col1 - 1];
        int aboveArea = prefix[row1 - 1][col2];
        int commonVal = prefix[row1 - 1][col1 - 1];

        int totalArea = endArea - leftArea - aboveArea + commonVal;

        return totalArea;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */