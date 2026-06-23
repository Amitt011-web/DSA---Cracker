/*
You are given three integers n, l, and r.

A ZigZag array of length n is defined as follows:

Each element lies in the range [l, r].
No two adjacent elements are equal.
No three consecutive elements form a strictly increasing or strictly decreasing sequence.
Return the total number of valid ZigZag arrays.

Since the answer may be large, return it modulo 109 + 7.

A sequence is said to be strictly increasing if each element is strictly greater than its previous one (if exists).

A sequence is said to be strictly decreasing if each element is strictly smaller than its previous one (if exists).

 Example 1:
Input: n = 3, l = 4, r = 5
Output: 2

Explanation:
There are only 2 valid ZigZag arrays of length n = 3 using values in the range [4, 5]:
[4, 5, 4]
[5, 4, 5]
​​​​​​​
Example 2:
Input: n = 3, l = 1, r = 3
Output: 10

Explanation:
There are 10 valid ZigZag arrays of length n = 3 using values in the range [1, 3]:
[1, 2, 1], [1, 3, 1], [1, 3, 2]
[2, 1, 2], [2, 1, 3], [2, 3, 1], [2, 3, 2]
[3, 1, 2], [3, 1, 3], [3, 2, 3]

All arrays meet the ZigZag conditions.

Constraints:
3 <= n <= 2000
1 <= l < r <= 2000
*/

//     SOLUTION    //
class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1;
        long mod = 1000000007;

        long[][] dp = new long[k + 2][2];
        
        for (int j = 1; j <= k; j++) {
            dp[j][0] = j - 1; 
            dp[j][1] = k - j;
        }

        for (int i = 3; i <= n; i++) {
            long[][] next = new long[k + 2][2];

            long[] p = new long[k + 2]; 
            long[] s = new long[k + 2]; 
            
            for (int j = 1; j <= k; j++) {
                p[j] = (p[j - 1] + dp[j][1]) % mod;
            }
            for (int j = k; j >= 1; j--) {
                s[j] = (s[j + 1] + dp[j][0]) % mod;
            }

            for (int j = 1; j <= k; j++) {
                next[j][0] = p[j - 1];
                next[j][1] = s[j + 1];
            }

            dp = next;
        }

        long ans = 0;
        for (int j = 1; j <= k; j++) {
            ans = (ans + dp[j][0] + dp[j][1]) % mod;
        }

        return (int) ans;
    }
}
