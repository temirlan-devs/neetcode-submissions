class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        int sum = 0;

        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }


        int l = 0;
        int counter = 0;
        for (int r = k - 1; r < arr.length; r++) {
            sum += arr[r];

            int avg = sum / k;
            if (avg >= threshold) {
                counter++;
            }
                            sum -= arr[l];
                l++;
        }

        return counter;

    }
}