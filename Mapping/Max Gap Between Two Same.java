/*
Given a string s consisting of lowercase English letters, find the maximum number of characters between any two identical characters. If no character 
repeats, return -1.

Examples :
Input: s = "socks"
Output: 3
Explanation: There are 3 characters between the two occurrences of 's'.

Input: s = "for"
Output: -1
Explanation: No repeating character present.

Constraints: 1 ≤ |s| ≤ 105

*/

//      SOLUTION      //

class Solution {
    public int maxCharGap(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        int maxGap = -1;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            
            if (firstIndex[idx] == -1)  firstIndex[idx] = i;
            else {
                int gap = i - firstIndex[idx] - 1;
                maxGap = Math.max(maxGap, gap);
            }
        }
        return maxGap;
    }
}
