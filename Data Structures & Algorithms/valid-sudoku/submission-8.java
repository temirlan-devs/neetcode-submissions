class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Character>> rows = new HashMap<>();
        Map<Integer, List<Character>> cols = new HashMap<>();
        Map<String, List<Character>> subboxes = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char cur = board[r][c];
                if (cur == '.') continue;
                String subboxKey = (r / 3) + "," + (c / 3);
                boolean rowRule = rows.computeIfAbsent(r, k -> new ArrayList<>()).contains(cur);
                boolean colRule = cols.computeIfAbsent(c, k -> new ArrayList<>()).contains(cur);
                boolean subboxRule = subboxes.computeIfAbsent(subboxKey, k -> new ArrayList<>()).contains(cur);
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
