/*
                                USING TREESET

 
Given a string s of lowercase English letters, you can swap all occurrences of any two distinct characters at most once. Return the lexicographically 
 smallest string after this operation.
 
Examples:

Input: s = "ccad"
Output: "aacd"
Explanation: In ccad, we choose a and c and after doing the replacement operation once, we get aacd and this is the lexicographically smallest string possible. 
Input: s = "abba"
Output: "abba"
Explanation: In abba, we can get baab after doing the replacement operation once for a and b but that is not lexicographically smaller than abba.
So, the answer is abba.

Constraints:
1 ≤ |s| ≤ 105

*/

//        SOLUTION          //

class Solution {
    public String chooseSwap(String a) {
         TreeSet<Character> s = new TreeSet<>();

        for (int i = 0; i < a.length(); i++) s.add(a.charAt(i));

        char[] arr = a.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            s.remove(arr[i]);
            if (s.isEmpty()) break;

            char ch = s.first();

            if (ch < arr[i]) {
                char ch2 = arr[i];

                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == ch) arr[j] = ch2;
                    else if (arr[j] == ch2) arr[j] = ch;
                }
                return new String(arr);
            }
        }
        return a;
        
    }
}
