/*
Given an unsorted array arr[] of size n, containing elements from the range 1 to n, it is known that one number in this range is missing, and another number occurs twice in the array, find both the duplicate number and the missing number.

Examples:

Input: arr[] = [2, 2]
Output: [2, 1]
Explanation: Repeating number is 2 and the missing number is 1.

Input: arr[] = [1, 3, 3] 
Output: [3, 2]
Explanation: Repeating number is 3 and the missing number is 2.

Input: arr[] = [4, 3, 6, 2, 1, 1]
Output: [1, 5]
Explanation: Repeating number is 1 and the missing number is 5.

Constraints:
2 ≤ n ≤ 106
1 ≤ arr[i] ≤ n

*/

// SOLUTION //

// Way 1: Frequency Array Approach //
class Solution {
    ArrayList<Integer> findTwoElement(int nums[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        int[] count = new int[n + 1];
        
        int repeating = -1;
        int missing = -1;
        
        for (int i = 0; i < n; i++) count[nums[i]]++;
        
         for (int i = 1; i <= n; i++) {
            if (count[i] == 2) {
                repeating = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }
        
        result.add(repeating); 
        result.add(missing);   
        
        return result;
        
    }
}

// Way 2: Inplace Marking Approach (Negative Indexing)

class Solution {
    ArrayList<Integer> findTwoElement(int nums[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = nums.length;
        int repeating = -1, missing = -1;
        
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] < 0) {
                repeating = val;
            } else {
                nums[val - 1] = -nums[val - 1];
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }
        
        result.add(repeating);
        result.add(missing);
        return result;
    }
}
