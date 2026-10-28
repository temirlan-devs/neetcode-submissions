class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int l = 0, r = arr.length - 1;

        while (r - l >= k) {
            int diffL = Math.abs(arr[l] - x);
            int diffR = Math.abs(arr[r] - x);

            if (diffL <= diffR) r--;
            else l++;
        }

        List<Integer> res = new ArrayList<>();

        while (l <= r) {
            res.add(arr[l]);
            l++;
        }

        return res;

    }
}