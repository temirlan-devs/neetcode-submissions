class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int m = Arrays.stream(people).max().getAsInt();

        int[] count = new int[m + 1]; // O(m) - space


        // O(n) - time
        for (int p : people) count[p]++;

        int idx = 0, i = 1;

        // O(n), where n is the number of people
        while (idx < people.length) {
            // in total runs for O(m)
            while (count[i] == 0) i++;

            people[idx] = i;
            count[i]--;
            idx++;
        }

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

// Time complexity: O(n + m)
// Space complexity: O(m)

/*

Test

Case 1:
[5, 2, 2, 1] limit = 5

count[1] = 1
count[2] = 2
count[3] = 0
count[4] = 0
count[5] = 1

idx = 0, i = 1
while (0 < 4)
people[0] = 1
idx -> 1

while 1 < 4
people[1] = 2
idx -> 2

while 2 < 4
people[2] = 2
idx -> 3

while 3 < 4
people[3] = 5
idx -> 4

people: [1, 2, 2, 5] limit = 5

l = 0, r = 3, res = 0

while 0 <= 3
res -> 1
remain = 0, r -> 2

while 0 <= 2
res -> 2
remain = 3, r -> 1
l -> 1

while 1 <= 1
res -> 3
remain = 3, r -> 0

return 3

  




Case 2:
[1, 2, 3] limit = 4

after counting sort: [1, 2, 3]

l = 0, r = 2

while 0 <= 2
res -> 1
remain = 1, r -> 1
l -> 1

while 1 <= 1
res -> 2
remain = 2, r -> 0

return 2

Case 3:
[1] limit = 1

after sorting: [1]

l = 0, r = 0

while 0 <= 0
res -> 1
remain = 0, r -> -1

return 1





*/