class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int total = 0;

        for (int i = 0; i < k - 1; i++) {
            total += arr[i];
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