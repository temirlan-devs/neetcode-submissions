class Solution {

    int[] piles;

    public int minEatingSpeed(int[] piles, int h) {
        
        this.piles = piles;

        int maxBananas = Arrays.stream(piles).max().getAsInt(); // O(n) - time, where n is the size of piles

        int l = 1;
        int r = maxBananas;

        // O(logm), where m is max value in piles
        while (l <= r) {
            int m = l + (r - l) / 2;

            long res = isCorrect(m); // O(n) - time. scan each pile
            if (res > h) l = m + 1;
            else r = m - 1;
        }

        return l;

    }

    public long isCorrect (int val) {
        long hours = 0;
        for (int p : piles) {
            long result = (long) Math.ceil((double) p / val);
            hours += result;
        }
        return hours;
    }
}

/*

Time complexity: O(n) + O(n * logm) -> O(nlogm)
Space complexity: O(1)

*/

/*


Test

Case 1:

[1, 2, 3] h = 4

l = 1 -> 2
r = 3 -> 1
m = 2 -> 1

return 2

Case 2:
[5] h = 5

l = 1
r = 5 -> 2 -> 0
m = 3 -> 1

return 1

*/
