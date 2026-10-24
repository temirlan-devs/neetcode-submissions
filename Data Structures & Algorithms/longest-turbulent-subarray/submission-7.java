class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int l = 0, r = 1, res = 1;
        String prev = "";

        // O(n) - time
        while (r < arr.length) {

            if (arr[r - 1] > arr[r] && !">".equals(prev)) {
                res = Math.max(res, r - l + 1);
                r++;
                prev = ">";
            }

            else if (arr[r - 1] < arr[r] && !"<".equals(prev)) {
                res = Math.max(res, r - l + 1);
                r++;
                prev = "<";
            }

            else {
                r = (arr[r - 1] == arr[r]) ? (r + 1) : r;
                l = r - 1;
                prev = "";
            }

        }

        return res;

    }
}

// Time complexity: O(n). Space complexity: O(1)

/*

Test

Case 1:

[5, 4, 6, 1]

5 > 4 < 6 > 1

prev = empty; > ; < ; >
res = 1 -> 2 -> 3 -> 4

return 4

Case 2:
[1, 2, 3]

1 < 2 < 3
prev = empty ; < ; empty ; <
res = 1 -> 2

return 2

Case 3:

[5, 4, 6, 6, 5, 3]

5 > 4 < 6 = 6 > 5 > 3

prev = empty ; > ; < ; empty ; < ; empty; <
res = 1 -> 2 -> 3

return 3

Case 4:
[1]

return 1




*/