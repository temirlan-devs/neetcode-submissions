class Solution {

    int[] piles;

    public int minEatingSpeed(int[] piles, int h) {
        
        this.piles = piles;

        int maxBananas = Arrays.stream(piles).max().getAsInt();

        int l = 1;
        int r = maxBananas;

        while (l <= r) {
            int m = l + (r - l) / 2;

            long res = isCorrect(m);
            System.out.println("l: " + l + ", r: " + r);
            System.out.println("m: " + m);
            System.out.println("res: " + res);
            if (res > h) l = m + 1;
            else r = m - 1;
            
            System.out.println();
        }

        return l;

    }

    public long isCorrect (int val) {
        long hours = 0;
        for (int p : piles) {
            long result = (int) Math.ceil((double) p / val);
            hours += result;
        }

        return hours;


    }
}
