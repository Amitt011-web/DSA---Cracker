/*
Given a number n, find count of all binary sequences of length 2n such that sum of first n bits is same as sum of last n bits. 

Note: Since the anwer can be very large, so return the answer modulo 109+7.

Examples:

Input: n = 2
Output: 6
Explanation: There are 6 sequences of length 2*n, the sequences are 0101, 0110, 1010, 1001, 0000 and 1111.

Input: n = 1
Output: 2
Explanation: There are 2 sequence of length 2*n, the sequence are 00 and 11. 
Constraints:
1 ≤ n ≤ 105
*/

              // SOLUTION //

class Solution {
    static final int MOD = 1000000007;
    static long[] fact;
    static long[] invFact;

    static long modPow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) ans = (ans * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return ans;
    }

    static void precompute(int n) {
        fact = new long[2*n+1];
        invFact = new long[2*n+1];
        fact[0] = 1;
        for (int i = 1; i <= 2*n; i++) fact[i] = (fact[i-1] * i) % MOD;
        invFact[2*n] = modPow(fact[2*n], MOD-2);
        for (int i = 2*n-1; i >= 0; i--) invFact[i] = (invFact[i+1] * (i+1)) % MOD;
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n-r] % MOD;
    }

    public int computeValue(int n) {
        precompute(n);
        return (int)(nCr(2*n, n) % MOD);
    }
}


//             BRUTE FORCE APPROACH                //

class Solution {
    public int computeValue(int n) {
        int len = 2 * n;
        int count = 0;
        int total = 1 << len;
        for (int mask = 0; mask < total; mask++) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) sum1++;
            }
            for (int i = n; i < len; i++) {
                if (((mask >> i) & 1) == 1) sum2++;
            }
            if (sum1 == sum2) count++;
        }
        return count;
    }
}









