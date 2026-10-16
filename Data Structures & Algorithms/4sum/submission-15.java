class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums); // O(nlogn)


        // O(n)
        for (int i = 0; i < nums.length; i++) {
            
            if (target >= 0 && nums[i] > target) break;
            else if (target < 0 && nums[i] >= 0) break;

            if (i > 0 && nums[i] == nums[i -1]) continue;

            // O(n)
            for (int j = i + 1; j < nums.length; j++) {
                
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1;
                int r = nums.length - 1;

                // O(n)
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) r--;
                    else if (sum < target) l++;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++; r--;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                    }
                }

            }

        }        

        return result;

    }
}

/*
Time complexity: O(n) * O(n) * O(n) + O(nlogn) = O(n^3)
Space complexity: O(n ^ 3)

The while loop can add one quadruplet at most, and it runs for O(n) times -> so O(n) space
The second for loop run for O(n) times and inside there is while loop that does O(n) space per single iteration of a 
second for loop -> O(n ^ 2) space
The first for loop run for O(n) times and inside there is second for loop that does O(n^2) space per single iteration of
a first for loop -> O(n ^ 3) space
*/