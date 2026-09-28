class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int total = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            if (map.containsKey(total - k)) counter += map.get(total - k);
            map.put(total, map.getOrDefault(total, 0) + 1);
        }

        return counter;

    }
}