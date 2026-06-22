/*
Given an integer array height[], where height[i] represents the height of the ith bar arranged in a row, find the maximum rectangular area that can be formed by selecting any two bars. The area is calculated based on the original positions of the selected bars.

Examples :

Input: height[] = [2, 5, 4, 3, 7]
Output: 10
Explanation:

The maximum rectangular area is formed by selecting the bars of heights 5 and 7.
There are 2 bars between them, so the area is: min(5, 7) × 2 = 10
Input: height[] = [1, 3, 4]
Output: 1
Explanation: Selecting bars 1 and 4 gives one bar between them, so the area is: min(1, 4) × 1 = 1

Constraints:
1 ≤ height.size() ≤ 105
1 ≤ height[i] ≤ 104
*/

//      SOLTUINON      //

class Solution {
    public int maxArea(List<Integer> height) {
        if(height==null || height.isEmpty()) return 0;
        int i = 0, j = height.size()-1, maxArea = 0;

        while(i<j){
            int heights = Math.min(height.get(i), height.get(j));
            int widths = j-i-1;

            maxArea = Math.max(maxArea,(heights * widths));

            if(height.get(i)<height.get(j)) i++;
            else j--;
        }
        return maxArea;


    }
}
