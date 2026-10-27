class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new LinkedList<>(); // O(k) - space

        int l = 0;
        int[] res = new int[nums.length - k + 1]; // O(n - k + 1) space

        // O(n) - time
        for (int r = 0; r < nums.length; r++) {

            // O(n) in total
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[r]) {
                deq.removeLast();
            }

            deq.addLast(r);

            if (l > deq.getFirst()) deq.removeFirst();

            if (r + 1 >= k) {
                res[l] = nums[deq.getFirst()];
                l++;
            }
        }

        return res;

    }
}

/*

Time complexity: O(n)
Space complexity: O(k) + O(n - k + 1) = O(n). Auxiliary: O(k)


*/


/*

Test

Case 1:
[1, 2, 3, 4, 5] k = 3


deq: [4]
res: [3, 4, 5]
l = 0 -> 1 -> 2 -> 3

return res -> [3, 4, 5]

Case 2:
[9, 8, 7, 6] k = 2

deq: [2, 3]
res: [9, 8, 7]
l = 0 -> 1 -> 2 -> 3

return res -> [9, 8, 7]


Case 3:
[1, 2, 3, 3, 3, 3] k = 3


deq: [3, 4, 5]
res: [3, 3, 3, 3]
l = 0 -> 1 -> 2 -> 3 -> 4

return res -> [3, 3, 3, 3]

Case 4:
[1] k = 1

deq: [0]
res: [1]
l = 0 -> 1

return res -> [1]

*/
