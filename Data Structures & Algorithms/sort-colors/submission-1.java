class Solution {
    public void sortColors(int[] nums) {
        int[] counter = new int[3];

        for (int num : nums) {
            counter[num]++;
        }

        int index = 0;
        int zeroindex = 0;
        int oneindex = 0;
        int twoindex = 0;

        while (zeroindex < counter[0]) {
            nums[index] = 0;
            zeroindex++;
            index++;
        }

        while (oneindex < counter[1]) {
            nums[index] = 1;
            oneindex++;
            index++;
        }

        while (twoindex < counter[2]) {
            nums[index] = 2;
            twoindex++;
            index++;
        }
    }
}