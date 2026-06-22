/*
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 Example 1:
Input: text = "nlaebolko"
Output: 1
Example 2:

Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 
Constraints:
1 <= text.length <= 104
text consists of lower case English letters only.
 */

//      SOLUTION      //


class Solution {
    public int maxNumberOfBalloons(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch =='n'){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            
        }
        
        int a = Math.min(map.getOrDefault('b', 0), Math.min(map.getOrDefault('a', 0), map.getOrDefault('n', 0)));
        int b = Math.min(map.getOrDefault('l', 0), map.getOrDefault('o', 0));
        
        return Math.min(b/2, a);
    }
}
