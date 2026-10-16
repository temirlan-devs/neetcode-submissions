class Solution {

    int[] nums;
    List<Integer> quad;
    List<List<Integer>> res;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.nums = nums;
        this.quad = new ArrayList<>();
        this.res = new ArrayList<>();
        Arrays.sort(nums);
        kSum(4, 0, target);
        return res;

    }

    public void kSum(int k, int start, long target) {
        if (k != 2) {
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                quad.add(nums[i]);
                kSum(k - 1, i + 1, target - nums[i]);
                quad.remove(quad.size() - 1);
            }
            return;
        }

        int l = start, r = nums.length - 1;

        while (l < r) {
            long sum = (long) nums[l] + nums[r];
            if (sum < target) l++;
            else if (sum > target) r--;
            else {
                res.add(new ArrayList<>(quad));
                res.get(res.size() - 1).add(nums[l]);
                res.get(res.size() - 1).add(nums[r]);
                l++; r--;
                while (l < r && nums[l] == nums[l - 1]) l++;
                while (l < r && nums[r] == nums[r + 1]) r--;
            }
        }
        
        return;
    }
}