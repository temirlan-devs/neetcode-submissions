class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> deq = new ArrayDeque<>();

        int l = 0;

        int[] res = new int[nums.length - k + 1];

        for (int r = 0; r < nums.length; r++) {
            int cur = nums[r];
            while (!deq.isEmpty() && nums[deq.peekLast()] < cur) {
                deq.pollLast();
            }
            deq.offerLast(r);

            if (l > deq.peekFirst()) {
                deq.pollFirst();
            }

            if (r + 1 >= k) {
                res[l] = nums[deq.peekFirst()];
                l++;
            }

        }

        return res;

    }
}
