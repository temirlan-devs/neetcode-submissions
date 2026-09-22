class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> {
                int freqA = map.get(a);
                int freqB = map.get(b);
                return freqA - freqB;
            }
        );

        for (int num : map.keySet()) {
            heap.offer(num);
            if (heap.size() > k) heap.poll();
        }

        int[] res = new int[k];
        int i = 0;
        while (heap.size() > 0) {
            res[i] = heap.poll();
            i++;
        }

        return res;

        
    }
}
