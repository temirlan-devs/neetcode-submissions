class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;

        // Scans the window until we have k elements left -> O(n - k)
        while (r - l >= k) {
            int diffL = Math.abs(arr[l] - x);
            int diffR = Math.abs(arr[r] - x);
            if (diffL <= diffR) {
                r--;
            }
            else {
                l++;
            }
        }

        List<Integer> res = new ArrayList<>(); // O(k) - space

        // O(k), cause by the time we get here code makes sure that r - l < k
        // Here we append final k results into our list
        while (l <= r) {
            res.add(arr[l]);
            l++;
        }

        return res;
    }
}

// Time complexity: O(n - k) + O(k) = O(n)
// Space complexity: O(k)