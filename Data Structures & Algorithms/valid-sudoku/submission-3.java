class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<String, Set<Integer>> squares = new HashMap<>();

        int n = board.length;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                
                if (board[r][c] == '.') continue;

                String squareKey = (r / 3) + "," + (c / 3);
                int value = board[r][c] - '0';

                boolean ruleRow = rows.computeIfAbsent(r, k -> new HashSet<>()).contains(value);
                boolean ruleCol = cols.computeIfAbsent(c, k -> new HashSet<>()).contains(value);
                boolean ruleSquare = squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(value);
                boolean invalid = ruleRow || ruleCol || ruleSquare;

                if (invalid) return false;

                rows.get(r).add(value);
                cols.get(c).add(value);
                squares.get(squareKey).add(value);

            }
        }

        return true;

    }
}
