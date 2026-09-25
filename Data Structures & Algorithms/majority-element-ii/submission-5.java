class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);

            if (count.size() <= 2) continue;

            Map<Integer, Integer> new_count = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                if (entry.getValue() > 1)
                    new_count.put(entry.getKey(), entry.getValue() - 1);
            }
            count = new_count;
        }

        List<Integer> res = new ArrayList<>();
        for (int key : count.keySet()) {
            int counter = 0;
            for (int num : nums) {
                if (key == num) counter++;
            }
            if (counter > nums.length / 3) res.add(key);
        }

        return res;
    }
}