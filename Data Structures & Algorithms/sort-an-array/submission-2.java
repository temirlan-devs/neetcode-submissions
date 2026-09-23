class Solution {

    int[] nums;

    public int[] sortArray(int[] nums) {
        this.nums = nums;
        mergeSort(0, nums.length - 1);

        return nums;
    }

    public void mergeSort(int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;

        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, m, r);
    }

    public void merge(int l, int m, int r) {
        int i = l;
        int j = m + 1;

        List<Integer> temp = new ArrayList<>();

        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
            }
        }

        while (i <= m) {
            temp.add(nums[i]);
            i++;
        }
        while (j <= r) {
            temp.add(nums[j]);
            j++;
        }

        for (i = l; i <= r; i++) {
            nums[i] = temp.get(i - l);
        }
    }
}


/*

Test

Case:

[3, 4, 2, 1]

Most up to date version of array:
[1, 2, 3, 4]

mergeSort(0, 3):
  mergeSort(0, 1):
	mergeSort(0, 0) - base case
	mergeSort(1, 1) - base case
	merge(0, 0, 1):
		i = 0
		j = 1
		while 0 <= 0 && 1 <= 1
		  if 3 < 4
		   temp: {3}; i -> 1
		while 1 <= 1
		  temp: {3, 4}
		for i = 0 <= 1
		 nums[0] = 3
 		 nums[1] = 4
	end
  mergeSort(2, 3):
	mergeSort(2, 2) - base case
	mergeSort(3, 3) - base case
	merge(2, 2, 3):
		i = 2
		j = 3
		while 2 <= 2 && 3 <= 3
		  if 2 < 1
		  else
		    temp: {1}; j -> 4
		while 2 <= 2
		  temp: {1, 2}; i -> 3
		for i = 2 <= 3
		 nums[2] = 1
		 nums[3] = 2
   merge(0, 1, 3):
	while 0 <= 1 && 2 <= 3:
	 temp: {1}
	 temp: {1, 2}
	while 0 <= 1
	 temp: {1, 2, 3}
	 temp: {1, 2, 3, 4}
        for i = 0 <= 3
	  nums[0] = 1
	  nums[1] = 2
          nums[2] = 3
          nums[3] = 4
end


*/