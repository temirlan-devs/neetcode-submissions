class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int counter = 0;
        while (l <= r) {
            if (l == r && people[l] <= limit) {
                counter++;
                break;
            } 
            if (people[l] == limit) {
                counter++;
                l++;
                continue;
            } else if (people[r] == limit) {
                counter++;
                r--;
                continue;
            } else {
                int sum = people[l] + people[r];
                if (sum <= limit) {
                    counter++;
                    l++; r--;
                } else {
                    if (people[r] <= limit) counter++;
                    r--;
                }
            }
        }

        return counter;
    }
}