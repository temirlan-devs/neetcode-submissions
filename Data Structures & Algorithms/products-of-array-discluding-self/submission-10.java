class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];


        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = postfix * res[i];
            postfix *= nums[i];
        }

        return res;

    }
}  

/*


Time compplexity: O(n)

Space complexity: O(1)



Test

Case 1:
[2, 3, 4]
Expected: [12, 8, 6]

res -> [1, 2, 6]

postfix = 1

i = 2
res[2] = 1 * 6 = 6
postfix = 4
res -> [1, 2, 6]


i = 1
res[1] = 2 * 4 = 8
postfix = 12
res-> [1, 8, 6]

i = 0
res[0] = 12 * 1 = 12
postfix = 24
res -> [12, 8, 6]


Case 2:
[2, 3, 0]
Expected -> [0, 0, 6]

res -> [1, 2, 6]

postfix = 1

i = 2
res[2] = 1 * 6 = 6
postfix = 0
res -> [1, 2, 6]

i = 1
res[1] = 2 * 0 = 0
postfix = 0
res -> [1, 0, 6]

i = 0
res[0] = 1 * 0 = 0
postfix = 0
res -> [0, 0, 6]



Case 3:
[0, 8, 0]
Expected[0, 0, 0]

res -> [1, 0, 0]

postfix = 1

i = 2
res[2] = 0 * 1 = 0
postfix = 0
res -> [1, 0, 0]

i = 1
res[1] = 0 * 0 = 0
postfix = 0
res -> [1, 0, 0]

i = 0
res[0] = 1 * 0
postfix = 0
res -> [0, 0, 0]


*/
