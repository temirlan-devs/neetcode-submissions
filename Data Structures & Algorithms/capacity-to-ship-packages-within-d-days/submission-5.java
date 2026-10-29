class Solution {

    int[] weights;
    int target;

    public int shipWithinDays(int[] weights, int days) {
        this.weights = weights;
        this.target = days;

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

            if (canShip(m)) r = m - 1;
            else l = m + 1;
        }

        return l;

    }

    public boolean canShip (int capacity) {
        int days = 1;
        int total = 0;
        for (int weight : weights) {
            total += weight;
            if (total > capacity) {
                days++;
                total = weight;
                if (days > target) return false;
            }
        }
        return true;

    }
}