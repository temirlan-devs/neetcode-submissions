class Solution {
    public int maxProfit(int[] prices) {
        
        int l = 0;
        int maxprofit = 0;

        for (int r = 1; r < prices.length; r++) {

            if (prices[l] < prices[r]) {
                maxprofit = Math.max(maxprofit, prices[r] - prices[l]);
            }

            else {
                l = r;
            }

        }

        return maxprofit;

    }
}
