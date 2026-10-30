class Solution {

    int x;

    public int mySqrt(int x) {
        this.x = x;
        int l = 1;
        int r = x;

        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = isCorrect(m);

            if (res > 0) r = m - 1;
            else if (res < 0) l = m + 1;
            else return m;
        
        }

        return r;
    }

    public int isCorrect (long val) {
        long op = val * val;
        if (op > x) return 1;
        else if (op < x) return -1;
        else return 0;
    }


}



