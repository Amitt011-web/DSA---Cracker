/*
Binary Searchable Count
Difficulty: MediumAccuracy: 50.0%Submissions: 11K+Points: 4
Given an array arr[] consisting of n distinct integers, find the maximum count of integers that are binary searchable in the given array. Binary searchable elements are determined using the standard Binary Search implementation described below.

Initially l is 0 and r is size of array - 1 
while(l <= r), compute mid as floor of (l + r)/2 and compare with mid.
If the target element is same as mid, return true. Else if mid is smaller, change l = mid + 1, else change r = mid - 1.
For example:

In arr[] = [2, 1, 3, 4, 6, 5], the element 5 is not binary searchable. During Binary Search, the search eventually reaches the subarray containing 6, and since 6 > 5, the search moves left (r = mid - 1), causing the element 5 to be skipped.
In arr[] = [2, 1, 3, 4, 5, 6], the element 5 is binary searchable because the standard Binary Search process eventually reaches and finds 5.
Examples:

Input: arr[] = [1, 3, 2]
Output: 2
Explanation: arr[0], arr[1] can be found.
Input: arr[] = [2, 1, 3, 5, 4, 6]
Output: 4
Explanation: arr[0], arr[2], arr[4], arr[5] can be found.
Constraints:
1 ≤ n ≤ 105
1 ≤ arr[i] ≤ 105

*/

// SOLUTION //
class Solution {
    public int binarySearchable(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, n - 1, -(int)1e9, (int)1e9);
    }
    private int helper(int[] nums, int l, int r, int mini, int maxi) {
        if (l > r) return 0;
        
        int res = 0;
        int m = l + (r - l) / 2;
        
        if (mini < nums[m] && nums[m] < maxi) {
            res = 1;
        }
        
        int left = helper(nums, l, m - 1, mini, Math.min(nums[m], maxi));
        int right = helper(nums, m + 1, r, Math.max(mini, nums[m]), maxi);
        
        return res + left + right;
    }
}
