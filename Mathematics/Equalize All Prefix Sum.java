/*
Given a sorted array arr[]. For each i(0 ≤ i ≤ n-1), make all the elements of the array from index 0 to i equal, using the minimum number of operations.

In one operation you either increase or decrease the array element by 1. Return an array that contains the minimum number of operations for each i,
to accomplish the above task.

Note:  
For each index i, consider the original array without applying modifications made for previous indices.
Try to solve the problem using O(1) extra space (excluding the resultant array).

Examples :
Input: arr[] = [1, 6, 9, 12]
Output: [0, 5, 8, 14]
Explanation: 
For i = 0, prefix [1] already has all equal elements, so operations = 0.
For i = 1, make [1, 6] equal to 4, operations = |1 - 4| + |6 - 4| = 5.
For i = 2, make [1, 6, 9] equal to 6, operations = |1 - 6| + |6 - 6| + |9 - 6| = 8.
For i = 3, make [1, 6, 9, 12] equal to 8, operations = 7 + 2 + 1 + 4 = 14

Input: arr[] = [1, 1, 1, 7, 7, 10, 19]
Output: [0, 0, 0, 6, 12, 21, 33]
Explanation:
For i = 0, prefix [1] already has equal elements, so operations = 0.
For i = 1, prefix [1, 1] already has equal elements, so operations = 0.
For i = 2, prefix [1, 1, 1] already has equal elements, so operations = 0.
For i = 3, make [1, 1, 1, 7] equal to 1, operations = 6.
For i = 4, make [1, 1, 1, 7, 7] equal to 1, operations = 12.
For i = 5, make [1, 1, 1, 7, 7, 10] equal to 5, operations = 21.
For i = 6, make [1, 1, 1, 7, 7, 10, 19] equal to 7, operations = 33

Constraints:
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104

Sum of n over all test case does not exceed 106.

*/

//         SOOLUTION 1         //

class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        
        for(int i = 1; i<arr.length; i++){
            ans.add(ans.get(ans.size()-1) + (arr[i] - arr[i/2]));
        }
        return ans;
    }
}
//         SOOLUTION 2         //

class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
           
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;

        long leftSum = 0 , totalSum = 0;

        for(int i = 0; i < n; i++){
            totalSum += arr[i];

            int mid = i / 2;

            if(i == 0) leftSum =  arr[0];
            else if(mid != (i-1) / 2) leftSum  += arr[mid];

            long midEle = arr[mid];
            long leftEleCount = mid+1;
            long rightEleCount =  i - mid;

            long rightSum = totalSum - leftSum;

            long leftCost = (leftEleCount * midEle) - leftSum;
            long rightCost = rightSum - (rightEleCount * midEle);

            long totalCost = leftCost + rightCost;
            ans.add ((int) (totalCost));
        }
        return  ans;
        
    }
}
