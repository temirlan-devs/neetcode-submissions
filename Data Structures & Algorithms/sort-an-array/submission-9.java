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
        List<Integer> temp = new ArrayList<>();
        int i = l;
        int j = m + 1;

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