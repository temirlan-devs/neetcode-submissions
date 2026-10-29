class Solution {

    int[] weights;

    public int shipWithinDays(int[] weights, int days) {
        this.weights = weights;

        int max = 0;
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
            max = Math.max(max, weight);
        }

        int l = max;
        int r = sum;

        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = getDays(m);

            if (res > days) l = m + 1;
            else r = m - 1;
        }

        return l;

    }

    public int getDays (int capacity) {
        int days = 0;
        int total = 0;
        for (int weight : weights) {
            total += weight;
            if (total > capacity) {
                days++;
                total = weight;
            }
        }
        days++;
        return days;

    }
}