/*
Given a string s consisting only of characters a, b and c.
Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca",
"bcab", "bcabc", "cab", "cabc" and "abc" (again). 

Example 2:
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 

Example 3:
Input: s = "abc"
Output: 1
 
Constraints:
3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.
*/

//      SOLUTION    //

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), count = 0;
        int lastA = -1, lastB = -1, lastC = -1;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            if(ch=='a') lastA = i;
            else if(ch=='b') lastB = i;
            else if(ch=='c') lastC = i;
            
            if(lastA!=-1 && lastB!=-1 && lastC!=-1){
                int minIdx = Math.min(lastA, Math.min(lastB, lastC));
                count += minIdx + 1;
            }
        }
        return count;
    }
}
