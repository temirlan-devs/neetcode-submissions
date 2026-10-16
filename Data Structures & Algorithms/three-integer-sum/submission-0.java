class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int threesum = nums[i] + nums[l] + nums[r];

                if (threesum > 0) r--;
                else if (threesum < 0) l++;
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]); temp.add(nums[l]); temp.add(nums[r]);
                    result.add(temp);
                    l++; r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }
            }
        }

        return result;

    }
}
