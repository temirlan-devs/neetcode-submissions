class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int sum = 0;

        for (int i = 0; i < k - 1; i++) sum += arr[i];

        int l = 0;
        int count = 0;
        for (int i = k - 1; i < arr.length; i++) {
            sum += arr[i];

            int avg = sum / k;
            if (avg >= threshold) {
                count++;
            }
            sum -= arr[l];
            l++;
        }

        return count;

    }
}