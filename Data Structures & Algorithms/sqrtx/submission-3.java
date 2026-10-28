class Solution {

    int x;  

    public int mySqrt(int x) {
        this.x = x;
        long r = x;
        long l = 1;

        while (l <= r) {
            long m = l + (r - l) / 2;

            if (isCorrect(m) > 0) l = m + 1;
            else if (isCorrect(m) < 0) r = m - 1;
            else return (int)m;
        }

        return (int)r;

    }

    public int isCorrect(long val) {
        if (val * val < x) return 1;
        else if (val * val > x) return -1;
        else return 0;
    }
}