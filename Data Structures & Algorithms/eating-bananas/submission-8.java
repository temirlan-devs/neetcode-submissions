class Solution {

    int[] piles;

    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        int m = Arrays.stream(piles).max().getAsInt();

        int l = 1;
        int r = m;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            long res = isCorrect(mid);

            if (res > h) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }

    public long isCorrect(int val) {
        long hours = 0;

        for (int p : piles) {
            hours += Math.ceil((double) p / val);
        }

        return hours;
    }
}
