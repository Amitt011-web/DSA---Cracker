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

Example 2:
Input: n = 3, l = 1, r = 3
Output: 10
Explanation:
​​There are 10 valid ZigZag arrays of length n = 3 using values in the range [1, 3]:
[1, 2, 1], [1, 3, 1], [1, 3, 2]
[2, 1, 2], [2, 1, 3], [2, 3, 1], [2, 3, 2]
[3, 1, 2], [3, 1, 3], [3, 2, 3]

All arrays meet the ZigZag conditions.

 Constraints:
3 <= n <= 109
1 <= l < r <= 75​​​​​​​
*/

//      SOLUTION    //

class Solution {
    int mod = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[][] T = new long[m][m];
        for (int j = 0; j < m; j++) {
            for (int i = m - j; i < m; i++) {
                T[i][j] = 1; 
            }
        }

      long[][] powT = matPow(T, n - 1, m);

        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                total = (total + powT[i][j]) % mod;
            }
        }
        
         return (int) (total * 2 % mod);
    }

  
    long[][] matPow(long[][] base, long e, int m) {
        long[][] res = new long[m][m];
        for (int i = 0; i < m; i++) res[i][i] = 1; // Identity matrix

        while (e > 0) {
            if (e % 2 == 1) res = mul(res, base);
            base = mul(base, base);
            e >>= 1;
        }
        return res;
    }

    
    long[][] mul(long[][] A, long[][] B) {
        int m = A.length;
        long[][] C = new long[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                long sum = 0;
                for (int k = 0; k < m; k++) {
                    sum = (sum + A[i][k] * B[k][j]) % mod;
                }
                C[i][j] = sum;
            }
        }
        return C;
    }
}
