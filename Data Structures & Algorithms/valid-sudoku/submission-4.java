class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        int n = board.length;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = (r / 3) + "," + (c / 3);

                boolean ruleRow = rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]);
                boolean ruleCol = cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]);
                boolean ruleSquare = squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c]);
                boolean invalid = ruleRow || ruleCol || ruleSquare;

                if (invalid) return false;

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }

        return true;
    }
}
