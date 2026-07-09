/**
* Given an integer n. Write a program to return the last digit of the number.
*
* Examples:
* Input: n = 10
* Output: 0
*
* Input: n = 9768
* Output: 8
*
* Constraints: -109 ≤ n ≤ 109
**/

      //      SOLUTION        //

import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int lastDigit = Math.abs(n % 10);
        System.out.println(lastDigit);
        
    }
}
