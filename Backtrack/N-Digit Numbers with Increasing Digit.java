/*
Given an integer n, return all the n digit numbers in increasing order, such that their digits are in strictly increasing order(from left to right).

Examples :

Input: n = 1
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Explanation: Single digit numbers are considered to be strictly increasing order.

Input: n = 2
Output: [12, 13, 14, 15, 16, 17, 18, 19, 23....79, 89]
Explanation: For n = 2, the correct sequence is 12 13 14 15 16 17 18 19 23 and so on up to 89.
Input: n = 15
Output: []
Explanation: No such number exist. 

Constraints:
1 ≤ n ≤ 105
*/

//      SOLUTION    //
class Solution {
      public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        if (n > 9 || n <= 0) return list;
        if(n==1) list.add(0);
        backtrack(0, list, 0, n);
        return list;

    }

    private static void backtrack(int currNumber, ArrayList<Integer> list, int lastNumber, int remainNumber) {
        if(remainNumber == 0) {
            list.add(currNumber);
            return;
        }

        for(int i = lastNumber+1; i <= 9 ; i++) {
            backtrack(currNumber * 10 + i, list, i, remainNumber-1);
        }

    }
}
