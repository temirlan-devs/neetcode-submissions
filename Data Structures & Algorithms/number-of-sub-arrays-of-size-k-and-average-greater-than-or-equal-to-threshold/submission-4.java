class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int total = 0;

        for (int r = 0; r < k - 1; r++) {
            total += arr[r];
        }

        int l = 0;
        int count = 0;
        for (int r = k - 1; r < arr.length; r++) {
            total += arr[r];

            int avg = total / k;
            if (avg >= threshold) count++;
            total -= arr[l];
            l++;
        }

        return count;
    }
}