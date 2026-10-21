class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (map.size() > 2) {
                Map<Integer, Integer> newmap = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > 1) {
                        newmap.put(entry.getKey(), entry.getValue() - 1);
                    }
                }
                map = newmap;
            }

        }

        List<Integer> res = new ArrayList<>();
        for (int key : map.keySet()) {
            int count = 0;
            for (int num : nums) {
                if (key == num) count++;
            }
            if (count > nums.length / 3) res.add(key);
        }

        return res;

    }
}