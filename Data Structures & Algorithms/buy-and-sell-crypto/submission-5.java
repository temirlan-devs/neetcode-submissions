class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;

        int maxProfit = 0;

        // O(n)
        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                maxProfit = Math.max(maxProfit, (prices[r] - prices[l]));
            } else {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}

// Time complexity: O(n). Space complexity: O(1)

/*

Test

Case 1:

[3, 5, 6, 1, 7]

3 < 5 -> 2
3 < 6 -> 3
3 < 1 false 
1 < 7 -> 6

maxProft = 0 -> 2 -> 3 -> 6

return 6

Case 2:
[3, 2, 1]

3 < 2 false
2 < 1 false

maxProfit = 0

return 0

Case 3:
[1]

return 0

Case 4:
[0, 2]

0 < 2 -> 2

maxProfit = 0 -> 2

return 2


*/
