class Solution {
    int[] piles;
    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        int max = Arrays.stream(piles).max().getAsInt();

        int l = 1;
        int r = max;

        while (l <= r) {
            int m = l + (r - l) / 2;

            long res = isCorrect(m);
            if (res > h) l = m + 1;
            else r = m - 1;
        }

        return l;
    }

    public long isCorrect (int val) {
        int hours = 0;
        for (int p : piles) {
            hours += Math.ceil((double) p / val);
        }

        return hours;
    }
}
