class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> subboxes = new HashMap<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char cur = board[r][c];
                if (cur == '.') continue;

                String subboxKey = (r / 3) + "," + (c / 3);

                boolean rowRule = rows.computeIfAbsent(r, k -> new HashSet<>()).contains(cur);
                boolean colRule = cols.computeIfAbsent(c, k -> new HashSet<>()).contains(cur);
                boolean subboxRule = subboxes.computeIfAbsent(subboxKey, k -> new HashSet<>()).contains(cur);
                boolean invalid = rowRule || colRule || subboxRule;
                if (invalid) return false;

                rows.get(r).add(cur);
                cols.get(c).add(cur);
                subboxes.get(subboxKey).add(cur);
            }
        }

        return true;
    }
}
