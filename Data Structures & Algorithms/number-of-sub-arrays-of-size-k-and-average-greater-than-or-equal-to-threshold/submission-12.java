class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int sum = 0;

        for (int i = 0; i < k - 1; i++) sum += arr[i];

        int count = 0;
        int l = 0;

        for (int r = k - 1; r < arr.length; r++) {
            sum += arr[r];

            int avg = sum / k;
            if (avg >= threshold) count++;

            sum -= arr[l];
            l++;
        }

        return count;

    }
}