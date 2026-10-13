class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += (prices[i] - prices[i - 1]);
        }

        return profit;
    }
}

// Time complexity: O(n). Space complexity: O(1)

/*

Test

Case 1:
[1, 5, 4, 10]

for loop
5 > 1 -> profit = 4
4 > 5 no
10 > 4 -> profit = 10

return 10

Case 2:
[1, 5, 6]

for loop
5 > 1 -> profit = 4
6 > 5 -> profit = 5

return 5

Case 3:
[7, 6]

for loop
6 > 7 no
return 0

Case 4:
[0, 1]

for loop
1 > 0 -> profit = 1

return 1


Case 5:
[1]

return 0



*/
