class Solution {
    public int maxProfit(int[] prices) {
        

        int min = prices[0];
        int profit = 0;
        for (int r = 1; r < prices.length; r++) {
            profit = Math.max(profit, (-min + prices[r]));
            min = Math.min(min, prices[r]);
        }

        return profit;
        


    }
}
