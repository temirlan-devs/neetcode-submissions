class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {


        int l = 0;
        int r = k;

        for (r = k; r < arr.length; r++) {
            
            int diffL = Math.abs(arr[l] - x);
            int diffR = Math.abs(arr[r] - x);
            if (diffR < diffL) l++;
            else if (diffR == diffR) {
                if (arr[l] < arr[r]) break;
                l++;
            }
            else break;


        }

        List<Integer> res = new ArrayList<>();
        while (l < r) {
            res.add(arr[l]);
            l++;
        }

        return res;

    }
}