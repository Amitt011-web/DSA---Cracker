/*
Given two integers a and b in the form of strings. Return the last digit of ab.

Examples:

Input: a = "3", b = "10"
Output: 9
Explanation: 310 = 59049. Last digit is 9.
Input: a = "6", b = "2"
Output: 6
Explanation: 62 = 36. Last digit is 6.
Constraints:
1 ≤ a.size(), b.size() ≤ 1000
a and b consist only of numeric digits ('0' - '9')
a and b do not contain any leading zeros, except when number itself is "0"

*/

//    SOLUTION      //

class Solution {
    public int getLastDigit(String a, String b) {
        if (b.equals("0")) return 1;
        if (a.equals("0")) return 0;
        
        int lastDigitA = a.charAt(a.length() - 1) - '0';

        int remaninderB = 0;
        if (b.length() > 2) {
            String lastTwo = b.substring(b.length() - 2);
            remaninderB = Integer.parseInt(lastTwo) % 4;
        } else {
            remaninderB = Integer.parseInt(b) % 4;
        }
      
        int exponent = (remaninderB == 0) ? 4 : remaninderB;
        
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result = (result * lastDigitA) % 10;
        }
        
        return result;
    }
}

