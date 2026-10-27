class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> deq = new ArrayDeque<>();

        int l = 0;

        int[] res = new int[nums.length - k + 1];

        for (int r = 0; r < nums.length; r++) {

            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[r]) {
                deq.removeLast();
            }

            deq.offer(r);

            if (l > deq.getFirst()) {
                deq.pollFirst();
            }

            if (r + 1 >= k) {
                res[l] = nums[deq.getFirst()];
                l++;
            }

        }

        return res;

    }
}
