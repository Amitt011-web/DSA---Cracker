/**
* Given a number n, find the number of ways to represent this number as a sum of 2 or more consecutive natural numbers.
*
* Examples:
* Input: n = 10
* Output: 1
* Explanation: There is only one way, 10 = 1+2+3+4.
*
* Input: n = 15
* Output: 3
* Explanation: There are 3 ways, (15 = 1+2+3+4+5), (15 = 4+5+6) and (15 = 7+8).
*
* Constraints:
* 1 ≤ n ≤ 108
**/

        //      SOLUTION        //

class Solution {
    public int getCount(int n) {
        int ans = 0;
        int limit = (int) Math.sqrt(2 * n);
        
        for (int i = 1; i <= limit; i++) {
            if ((n - (i * i - i) / 2) % i == 0) {
                ans++;
            }
        }
        return ans - 1;
    }
}
