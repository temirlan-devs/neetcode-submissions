/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        int l = 1;
        int r = n;

        // O(logn) - time
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            int res = guess(mid);
            if (res > 0) l = mid + 1;
            else if (res < 0) r = mid - 1;
            else return mid;
        }

        return -1;

    }
}

// Time complexity: O(logn). Space complexity: O(1)

/*

Test 

Case 1:
n = 4 pick = 2

l = 1
r = 4
mid = 2

return 2

Case 2:
n = 6 pick = 5

l = 1 -> 4
r = 6
mid = 3 -> 5

return 5

Case 3:
n = 1 pick = 1

l = 1
r = 1
mid = 1

return 1

Case 4:
n = 4 pick = 1

l = 1
r = 4 -> 1
mid = 2 -> 1

return 1

Case 5:
n = 3 pick = 3

l = 1 -> 3
r = 3
mid = 2 -> 3

return 3



*/
