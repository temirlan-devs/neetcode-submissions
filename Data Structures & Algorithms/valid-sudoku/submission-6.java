class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = (r / 3) + "," + (c / 3);

                boolean rowRule = rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]);
                boolean colRule = cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]);
                boolean squareRule = squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c]);
                boolean invalid = rowRule || colRule || squareRule;

                if (invalid) return false;

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);

            }
        }

        return true;
    }
}
