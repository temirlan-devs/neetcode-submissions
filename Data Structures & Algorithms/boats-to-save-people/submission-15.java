class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int m = Arrays.stream(people).max().getAsInt();

        int[] count = new int[m + 1]; // O(m) - space

        // O(n) - time
        for (int p : people) count[p]++;

        int idx = 0, i = 1;

        // O(n) - space
        while (idx < people.length) {
            // O(m) - total
            while (count[i] == 0) i++;

            people[idx] = i;
            count[i]--;
            idx++;
        }

        // Time: O(n) + O(m)
        // Space: O(m)

        int l = 0, r = people.length - 1;
        int res = 0;
        // O(n) - time
        while (l <= r) {
            res++;
            int remain = limit - people[r--];
            if (l <= r && people[l] <= remain) l++;
        }

        return res;
    }
}