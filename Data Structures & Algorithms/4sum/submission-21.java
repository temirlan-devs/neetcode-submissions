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

    public void kSum (int k, int start, long target) {
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
            int sum = nums[l] + nums[r];
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

/*

Test

Case 1:
[-1, -1, 0, 1, 2] target = 2

kSum(4, 0, 2):
  for i = 0 < 2
    q -> -1
    kSum(3, 1, 3):
      for i = 1 < 3
	q -> -1, -1
	kSum(2, 2, 4):
	  l = 2 r = 4
	  while (2 < 4)
	   sum = 2; l -> 3
	  while 3 < 4
           sum = 3; l -> 4
	  return
        q -> -1
       for i = 2 < 3
	 q -> -1, 0
         kSum(2, 3, 3):
	   l = 3 r = 4
	   while 3 < 4
	     sum = 3
	     res -> {{-1, 0, 1, 2}}
	     l -> 4 r -> 3
           return
	return
      q -> 
   for i = 1 < 2
      1 > 0 && -1 == -1 continue
   return
return res -> {{-1, 0, 1, 2}}

Case 2:
[1] target = 1

kSum(4, 0, 1):
	for i = 0 < -2 -> end
        return
return res -> {{}}



*/
