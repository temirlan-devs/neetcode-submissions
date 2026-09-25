class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new ArrayList<>();
        
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);

            if (count.size() <= 2) continue;

            Map<Integer, Integer> new_count = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                if (entry.getValue() > 1) {
                    new_count.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            count = new_count;
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int counter = 0;
            for (int num : nums) {
                if (entry.getKey() == num) {
                    counter++;
                }
            }
            if (counter > (nums.length / 3)) result.add(entry.getKey());
        }

        return result;

    }
}