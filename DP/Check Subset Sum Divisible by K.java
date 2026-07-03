/*
Given an array arr[] of positive integers and a value k. Return true if the sum of any non-empty subset of the given array is divisible by
k otherwise, return false.

Examples:
Input: arr[] = [3, 1, 7, 5] , k = 6
Output: true
Explanation: If we take the subset {7, 5} then sum will be 12 which is divisible by 6.

Input: arr[] = [1, 2, 6] , k = 5
Output: false
Explanation: All possible subsets of the given set are {1}, {2}, {6}, {1, 2}, {2, 6}, {1, 6} and {1, 2, 6}. There is no subset whose sum is divisible by 5.

Constraints:
1 ≤ arr.size(), k ≤ 103
1 ≤ arr[i] ≤ 103
*/

//      SOLUTION      //

class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        int n = arr.length;
        if (k == 1) return true;

        boolean[] dp = new boolean[k];
        for (int num : arr) {
            int currReminder = num % k;
            if (currReminder == 0) return true;
            
            List<Integer> nextReminders = new ArrayList<>();
            nextReminders.add(currReminder);
            
            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    int newRem = (r + currReminder) % k;
                    if (newRem == 0) return true;
                    nextReminders.add(newRem);
                }
            }
            for (int rem : nextReminders) dp[rem] = true;
        }
        return false;
    }
}
