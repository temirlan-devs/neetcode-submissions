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

/*

Test

Case 1:

[1, 2, 3] x = 4 k = 2

l = 0 -> 1
r = 2

23
res -> {2, 3}

return res


Case 2:

[8, 9, 10, 11] x = 7 k = 2

l = 0 
r = 3 -> 2 -> 1

8 9
res -> {8, 9}

return res

Case 3:

[5, 6, 7, 13, 15]  x = 10 k = 1

l = 0 -> 1 -> 2
r = 4 -> 3 -> 2

7 
res -> {7}

return res

Case 4:

[5] k = 1

l = 0
r = 0

res -> {5}

return res


*/

/*


Sliding window approach either, but fiddlier

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {


        int l = 0;
        int r = k;

        for (r = k; r < arr.length; r++) {
            
            int diffL = Math.abs(arr[l] - x);
            int diffR = Math.abs(arr[r] - x);
            if (diffR < diffL) l++;
            
            else if (diffR == diffL) {
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
*/
