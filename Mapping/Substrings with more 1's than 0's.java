/*
Given a binary string s consists only of 0s and 1s. Calculate the number of substrings that have more 1s than 0s.

Examples :
Input : s = "011"
Output : 4
Explanation : There are 4 substring which has more 1s than 0s. i.e "011","1","11" and "1.

Input : s = "0000"
Output : 0
Explanation : There is no substring with more 1s than 0s

Constraints : 1 < |s| <  6 * 104


*/

//        SOLUTION        //

class Solution {
    public int countSubstring(String str) {
        int n = str.length();
        int count = 0, sum = 0, curr = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i < n; i++){
            char ch =  str.charAt(i);

            if(ch=='1'){
                curr += map.getOrDefault(sum, 0);
                sum++;
            }
            else{
                sum--;
                curr -= map.getOrDefault(sum, 0);
            }

            count += curr;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
        
    }
}
