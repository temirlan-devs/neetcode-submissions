class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};

    }
}

/*
Time, space complexity: O(n)

Test

Case 1:
[1, 2, 3, 4] target = 3

map: 1->0
diff = 1 -> return 0, 1

Case 2:
[1, 2, 3, 4] target = 5

map: 1->0
map: 1->0; 2->1
diff = 2 -> return 1, 2

Case 3:
[]
return -1, -1

*/
