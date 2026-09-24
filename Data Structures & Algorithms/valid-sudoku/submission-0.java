class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int n = 9;
        int[][] rows = new int[n][n + 1];
        int[][] cols = new int[n][n + 1];
        int[][] subboxes = new int[n][n + 1];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int subboxindex = getSubboxIndex(r, c);

                int curChar = board[r][c];
                if (!Character.isDigit(curChar)) continue;

                int value = curChar - '0';
                if (value < 1 || value > 10) return false;
                rows[r][value]++;
                cols[c][value]++;
                subboxes[subboxindex][value]++;

                if (rows[r][value] > 1) return false;
                if (cols[c][value] > 1) return false;
                if (subboxes[subboxindex][value] > 1) return false;
            }
        }

        return true;
    }

    public int getSubboxIndex(int row, int col) {
        int colindex = col / 3;
        int rowindex = row / 3;

        if (rowindex == 1) {
            colindex += 3;
        }

        if (rowindex == 2) {
            colindex += 6;
        }

        return colindex;
    }
}
