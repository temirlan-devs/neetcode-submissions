class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char cur = board[r][c];
                if (cur == '.') continue;
                String squareKey = (r / 3) + "," + (c / 3);
                boolean rowRule = rows.computeIfAbsent(r, k -> new HashSet<>()).contains(cur);
                boolean colRule = cols.computeIfAbsent(c, k -> new HashSet<>()).contains(cur);
                boolean squareRule = squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(cur);
                boolean invalid = rowRule || colRule || squareRule;

                if (invalid) return false;

                rows.get(r).add(cur);
                cols.get(c).add(cur);
                squares.get(squareKey).add(cur);
            }
        }

        return true;
    }
}
