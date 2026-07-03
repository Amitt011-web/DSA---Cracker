/*
Given two strings s1 and s2 consisting of lowercase English letters of length n1 and n2 respectively, find the number of ways to insert exactly 
one character into string s1 such that the length of the Longest Common Subsequence (LCS) of both strings increases by exactly 1.

Examples :
Input: s1 = "abab", s2 = "abc"
Output: 3
Explanation: The LCS length of the given two strings is 2. There are 3 valid insertions in s1 which increase the LCS length to 3:
"abcab" -> LCS = 3
"abacb" -> LCS = 3
"ababc" -> LCS = 3

Input: s1 = "abcabc", s2 = "abcd"
Output: 4
Explanation: The LCS length of the given two strings is 3. There are 4 valid insertions in s1 which increase the LCS length to 4:
"abcdabc" -> LCS = 4
"abcadcb" -> LCS = 4
"abcabdc" -> LCS = 4
"abcabcd" -> LCS = 4

Constraints:
1<= n1, n2 <=100
*/

//        SOLUTION    //               Dynamic Programming (Prefix + Suffix) + Index Mapping + HashSet

class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        List<List<Integer>> positions = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            positions.add(new ArrayList<>());
        }
        for (int j = 1; j <= n2; j++) {
            positions.get(s2.charAt(j - 1) - 'a').add(j);
        }

        int[][] lcsl = new int[n1 + 2][n2 + 2];
        int[][] lcsr = new int[n1 + 2][n2 + 2];

        // Forward DP (Prefix LCS)
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcsl[i][j] = lcsl[i - 1][j - 1] + 1;
                } else {
                    lcsl[i][j] = Math.max(lcsl[i - 1][j], lcsl[i][j - 1]);
                }
            }
        }

        // Backward DP (Suffix LCS)
        for (int i = n1; i >= 1; i--) {
            for (int j = n2; j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcsr[i][j] = lcsr[i + 1][j + 1] + 1;
                } else {
                    lcsr[i][j] = Math.max(lcsr[i + 1][j], lcsr[i][j + 1]);
                }
            }
        }

        int base = lcsl[n1][n2];
        Set<String> uniqueWays = new HashSet<>();

        for (int i = 0; i <= n1; i++) {
            for (int c = 0; c < 26; c++) {
                char ch = (char) (c + 'a');
                for (int p : positions.get(c)) {
                    if (lcsl[i][p - 1] + lcsr[i + 1][p + 1] == base) {
                        uniqueWays.add(i + "_" + ch); 
                        break;
                    }
                }
            }
        }
        return uniqueWays.size();
    }
}
