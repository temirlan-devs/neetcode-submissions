class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // O(n)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.size() <= 2) continue;

            Map<Integer, Integer> new_map = new HashMap<>(); 
            // O(2)
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    new_map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        // O(2)
        for (int key : map.keySet()) {
            int counter = 0;
            // O(n)
            for (int num : nums) {
                if (key == num) counter++;
            }
            if (counter > (nums.length / 3)) res.add(key);
        }

        return res;

    }
}

// Time complexity: O(2 * n) -> O(n)
// Space complexity: O(2) -> O(1)