/**
* Given an array arr[] and positive integer k, count total number of pairs in the array whose sum is divisible by k.
*
* Examples:
* Input :  arr[] = [2, 2, 1, 7, 5, 3], k = 4
* Output : 5
* Explanation : There are five pairs possible whose sum is divisible by '4' i.e., (2, 2), (1, 7), (7, 5), (1, 3) and (5, 3).
*
* Input : arr[] = [5, 9, 36, 74, 52, 31, 42], k = 3
* Output : 7 
* Explanation : There are seven pairs whose sum is divisible by 3, i.e, (9, 36), (9,42), (74, 52), (36, 42), (74, 31), (31, 5) and (5, 52).
* 
* Constraints :
* 1 ≤ |arr| ≤ 5*104
* 1 ≤ arr[i] ≤ 106
* 1 ≤ k ≤ 5*104
**/

      //      SOLUTION      //

class Solution {
    public int countKdivPairs(int[] arr, int k) {
        long ans = 0;
           
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
               
            int rem = ((num % k) + k) % k;
            int requiredRem = (k - rem) % k;

            if (map.containsKey(requiredRem)) {
                ans += map.get(requiredRem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return (int) ans;
    }
}
