class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new LinkedList<>();

        int l = 0;
        int[] res = new int[nums.length - k + 1];

        for (int r = 0; r < nums.length; r++) {
            
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
